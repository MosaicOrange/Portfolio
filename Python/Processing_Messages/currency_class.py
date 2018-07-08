
class Currency(object):
	def __init__(self, international_name, represented_symbol, iso4217_code, short_name, \
			thousand_separator, decimal_separator, decimal_character, decimal_place):
		self.international_name = international_name
		self.represented_symbol = represented_symbol
		self.iso4217_code = iso4217_code
		self.short_name = short_name
		self.thousand_separator = thousand_separator
		self.decimal_separator = decimal_separator
		self.decimal_character = decimal_character
		self.decimal_place = decimal_place

	def get_international_name(self):
		return self.international_name

	def get_represented_symbol(self):
		return self.represented_symbol

	def get_iso4217_code(self):
		return self.iso4217_code

	def get_iso4217_code(self):
		return self.iso4217_code

	def get_short_name(self):
		return self.short_name

	def get_thousand_separator(self):
		return self.thousand_separator

	def get_decimal_separator(self):
		return self.decimal_separator

	def get_decimal_character(self):
		return self.decimal_character

	def get_decimal_place(self):
		return self.decimal_place

	def _format_whole_money(self, some_int_as_string, whole_mode):
		whole_money = ''
		temp_money = some_int_as_string
		while len(temp_money) > 0:
			whole_money = temp_money[-3:] + self.thousand_separator + whole_money
			temp_money = temp_money[:-3]
		whole_money = whole_money[:-1]
		if whole_mode == 'currency':
			return self.represented_symbol + whole_money
		elif whole_mode == 'symbols':
			return self.short_name + ' ' + whole_money
		elif whole_mode == 'plain':
			return whole_money
		return None

	def _format_partial_money(self, some_int_as_string, partial_mode):
		append = ''
		if self.decimal_place > len(some_int_as_string):
			append = '0' * (self.decimal_place - len(some_int_as_string))
		if partial_mode in ['plain', 'currency']:
			return self.decimal_separator + some_int_as_string[:self.decimal_place] + append
		elif partial_mode == 'symbols':
			return ' ' + some_int_as_string[:self.decimal_place] + append + self.decimal_character
		return None

	def get_formatted_money(self, some_value, whole_mode, partial_mode):
		if not isinstance(some_value, (int, float)):
			return None

		temp = str(some_value).split('.')
		if (len(temp) == 2 and self.decimal_place == 0):
			return None

		whole_mode = whole_mode.lower()
		partial_mode = partial_mode.lower()
		accepted_modes = ['currency', 'symbols', 'plain']

		if whole_mode not in accepted_modes \
				or partial_mode not in accepted_modes:
			return None

		return_value = None
		if round(some_value,0) == some_value:
			return_value = self._format_whole_money(temp[0], whole_mode)
		elif len(temp) == 2:
			if temp[1] is not None and temp[1] is not '':
				return_value = self._format_whole_money(temp[0], whole_mode) + self._format_partial_money(temp[1], partial_mode)
		return return_value

default_global_currencies = {
	'GBP' : Currency('Pound Sterling', '£', '826', 'GBP', ',', '.', 'p', 2),
	'USD' : Currency('US Dollar', '$', '840', 'USD', ',', '.', 'c', 2),
	'AUD' : Currency('Australian Dollar', '$', '036', 'AUD', ' ', '.', 'c', 2),
	'CNY' : Currency('China Yuan Renminbi', '¥', '156', 'CNY', ',', '.', 'j', 2),
	'JPY' : Currency('Japanese Yen', '¥', '392', 'JPY', ',', '.', 's', 0),
	'EUR' : Currency('Euro', '€', '978', 'EUR', ',', '.', 'c', 2)
}

