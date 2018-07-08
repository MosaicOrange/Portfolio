
def _add_to(original_float, passed_value):
	return original_float + passed_value

def _subtract_from(original_float, passed_value):
	if original_float > passed_value:
		return original_float - passed_value
	return 0

def _multiply_with(original_float, passed_value):
	return original_float * passed_value

_operations_dictionary = {
	'add' : _add_to,
	'subtract' : _subtract_from,
	'multiply' : _multiply_with
}

def check_operations(operation_requested):
	if operation_requested.lower() in _operations_dictionary.keys():
		return True
	return False

def perform_operation(operation_requested, *passed_values):
	if check_operations(operation_requested):
		return _operations_dictionary[operation_requested.lower()](*passed_values)
	print(failed)
	return None
