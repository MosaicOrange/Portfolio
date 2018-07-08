

import sys

from operational_methods import perform_operation
from message_evaluation import evaluation_function

from sales_class import Sales
from operation_class import Operation
from currency_class import Currency, default_global_currencies

def main():
	def show_output(dictionary, currency):
		for key, sale_made in dictionary.items():
			print(key)
			print('\tTotal Sales:', len(sale_made))
			print('\tTotal Quantity:', '{0:.0f}'.format(sum([v.get_quantity() for v in sale_made])))
			print('\tTotal Value:', default_global_currencies[currency].get_formatted_money(sum([v.get_quantity() * v.get_price() for v in sale_made]),'plain', 'currency'))
			print('')

	def perform_evaluations(x, system_currency, given_products, msg):
		temp = evaluation_function(system_currency,msg)
		if isinstance(temp, Operation):
			if temp.get_operation() is None:
				if not temp.get_product() in given_products.keys():
					given_products[temp.get_product()] = [Sales(temp.get_quantity(),temp.get_price())]
				else:
					given_products[temp.get_product()].append(Sales(temp.get_quantity(),temp.get_price()))
			elif temp.get_product() in given_products.keys():
				sales_already_made = given_products[temp.get_product()]
				given_products[temp.get_product()] = list()
				for sale_made in sales_already_made:
					given_products[temp.get_product()].append(Sales(sale_made.get_quantity(),perform_operation(temp.get_operation(), sale_made.get_price(), temp.get_price())))

		if x%50 == 0 and x > 0:
			print(x , 'messages recieved, pausing')
			show_output(given_products, system_currency)
			exit()

		if x%10 == 0 and x > 0:
			print(x , 'messages recieved, reporting')
			show_output(given_products, system_currency)

	try:
		system_currency = sys.argv[1]
	except IndexError as err:
		system_currency = 'GBP'

	if system_currency not in default_global_currencies.keys():
		system_currency = 'GBP'

	user_text = '''
Select Usage Mode:
	1. Pick a [F]ile
	2. Enter data [M]anually
	3. [E]xit
'''

	invalid_option = '''
Invalid option, try again:
	1. [F] to load a file
	2. [M] to enter data manually
	3. [E] to exit
'''

	selected_option = input(user_text).lower()
	attempt_num = 0
	max_attempts = 3
	valid_options = [ 'f', 'm', 'e' ]
	while (selected_option not in valid_options) and attempt_num < max_attempts:
		attempt_num += 1
		selected_option = input(invalid_option).lower()
		if attempt_num >= max_attempts:
			selected_option = 'e'
			print('too many attempts, exiting')

	if selected_option == 'e':
		exit()

	x, given_products = 0, dict()
	if selected_option == 'f':
		file_selection = input('Please provide relative file path: ')
		try:
			with open(file_selection) as file:
				for line in file:
					perform_evaluations(x, system_currency, given_products, line)
					x += 1
		except FileNotFoundError as err:
			print('File not found, exiting')
			exit()

	if selected_option == 'm':
		while True:
			line = input('Submit a message (or [e] to exit: ')
			if line == 'e':
				exit()
			else:
				perform_evaluations(x, system_currency, given_products, line)
				x += 1
		


if __name__ == '__main__':
	main()

