
import re

from operational_methods import check_operations

from currency_class import default_global_currencies
from operation_class import Operation

_float_regex = re.compile(r'[+-]?\d+(?:\.\d+)?')

def _if_str_empty(passed_string):
	if passed_string is not None and passed_string is not '':
		return True
	return False

def _evaluate_str_number(short_name, passed_string):
	pre_eval = _float_regex.search(passed_string)
	if _if_str_empty(pre_eval):
		return_value = 0
		pre_eval = pre_eval.group(0)
		if passed_string[-1:].isalpha():
			currency_amount, currency_character = pre_eval, passed_string[-1:]
			if default_global_currencies[short_name].get_decimal_character() == currency_character:
				if len(currency_amount) == 1:
					return_value = float('0.0' + currency_amount)
				elif len(currency_amount) == 2:
					return_value = float(currency_amount[:-2] + '.' + currency_amount[-2:])
		elif len(pre_eval) == len(passed_string):
			return_value = float(pre_eval)
		if return_value > 0:
			return return_value
	return None

def _evaluate_product(passed_string):
	if not isinstance(passed_string,list):
		pre_eval = passed_string.split()
	elif len(passed_string) == 1:
		pre_eval = passed_string[0].split()
	else:
		pre_eval = passed_string
	if len(pre_eval) > 0 and len(pre_eval) < 4:
		return ' '.join(pre_eval)
	return None

def _msg_type_one(short_name, passed_list):

	if len(passed_list) > 1:
		product = _evaluate_product(passed_list[:-1])
		if _if_str_empty(product):
			price_step = passed_list[-1:][0].split()
			price = _evaluate_str_number(short_name,price_step[0])
			if price is not None:
				return Operation(message=1, operation=None, product=product, price=price, quantity=1)
	return None

def _msg_type_two(short_name, passed_list):
	first_step = passed_list[0].split()[0]
	if not first_step[-1:].isalpha():
		quantity = _evaluate_str_number(short_name, first_step)
		if quantity is not None:
			second_step = passed_list[1].split(' at ')
			if len(second_step) > 1:
				product_step = second_step[0].split()
				if len(passed_list) >= 1 and len(passed_list) < 4:
					price_step = second_step[1].split()
					third_step = _msg_type_one(short_name, second_step[0].split() + [price_step[0]])
					if _if_str_empty(third_step):
						product, price = third_step.get_product(), third_step.get_price()
						return Operation(message=2, operation=None, product=product, price=price, quantity=quantity)
	return None

def _msg_type_three(short_name, passed_list):
	if len(passed_list) >= 3 and len(passed_list) < 6:
		if check_operations(passed_list[0]):
			operation = passed_list[0].lower()
			first_step = _msg_type_one(short_name, passed_list[2:] + [passed_list[1]])
			if _if_str_empty(first_step):
				product, price = first_step.get_product(), first_step.get_price()
				return Operation(message=3, operation=operation, product=product, price=price, quantity=None)
	return None

def evaluation_function(short_name, some_string):
	if _if_str_empty(some_string):
		return_value = None
		test_1 = some_string.split(' of ')
		if len(test_1) == 2:
			return_value = _msg_type_two(short_name, test_1)
		elif len(test_1) == 1:
			test_2 = some_string.split(' at ')
			if len(test_2) == 2:
				return_value = _msg_type_one(short_name, test_2)
			elif len(test_2) == 1:
				test_3 = test_2[0].split()
				if check_operations(test_3[0]):
					return_value = _msg_type_three(short_name, test_3)
		if return_value is not None:
			return return_value
	return None
