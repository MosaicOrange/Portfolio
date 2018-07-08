
class Operation(object):
	def __init__(self, message, operation, product, price, quantity):
		self.message = message
		self.operation = operation
		self.price = price
		self.product = product
		self.quantity = quantity

	def get_message(self):
		return self.message

	def get_operation(self):
		return self.operation

	def get_product(self):
		return self.product

	def get_price(self):
		return self.price

	def get_quantity(self):
		return self.quantity

	def set_message(self, passed_int):
		if isinstance(passed_int, int):
			self.message = passed_int

	def set_price(self, passed_float):
		if isinstance(passed_float, (int,float)):
			self.price = passed_float

	def set_quantity(self, passed_float):
		if isinstance(passed_float, (int,float)):
			self.quantity = passed_float

	def set_product(self, passed_string):
		if isinstance(passed_string, str):
			self.product = passed_string

	def set_operation(self, passed_string):
		if isinstance(passed_string, str):
			self.operation = passed_string
