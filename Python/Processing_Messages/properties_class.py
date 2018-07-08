
class Properties(object):
	def __init__(self, quantity, price):
		if quantity is None:
			self.quantity = 0
		else:
			self.quantity = quantity
		if price is None:
			self.price = 0
		else:
			self.price = price

	def get_price(self):
		return self.price

	def get_quantity(self):
		return self.quantity

	def set_price(self, passed_float):
		if isinstance(passed_float, (int,float)):
			self.price = passed_float

	def set_quantity(self, passed_int):
		if isinstance(passed_int, int):
			self.quantity = passed_int
