

print(given_products['Apple'].get_quantity())
print(given_products['Apple'].get_price())

given_products['Apple'].set_quantity(2)
given_products['Apple'].set_price(10)

print(given_products['Apple'].get_quantity())
print(given_products['Apple'].get_price())


given_products['Apple'].set_quantity(perform_operation('Add', given_products['Apple'].get_quantity(), 2))
given_products['Apple'].set_price(perform_operation('Multiply', given_products['Apple'].get_price(), 2))

print(given_products['Apple'].get_quantity())
print(given_products['Apple'].get_price())