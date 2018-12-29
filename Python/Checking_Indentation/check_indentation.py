
import re, sys

# Triple Single Quote
T_S_Q = "'''"

#Triple Double Quote
T_D_Q = '"""'

REGEX_TEXT = r'[^\(\)\[\]\{\}]'
REGEX_BRACKET = r'[^\[\]]'
REGEX_LBRACKET = r'[^\[]'
REGEX_RBRACKET = r'[^\]]'
REGEX_BRACE = r'[^\{\}]'
REGEX_LBRACE = r'[^\{]'
REGEX_RBRACE = r'[^\}]'
REGEX_PAREN = r'[^\(\)]'
REGEX_LPAREN = r'[^\(]'
REGEX_RPAREN = r'[^\)]'

indent_character = None
indent_count = 0

triple_single_quote = False
triple_double_quote = False

open_function = False
previous_return = (False, 0)
open_function_indent = list()

semi_colon_set = False

previous_slash = False
previous_line = ''

open_bracket_count = 0
open_brace_count = 0
open_paren_count = 0


print('-' * 100)

def regex_string_splitter(regex_to_match, some_string):
	inner_temp_string = re.split(regex_to_match, some_string)
	if len(inner_temp_string) > 1:
		return ''.join(inner_temp_string[::2])
	else:
		return ''.join(inner_temp_string)

with open(sys.argv[1]) as file:
	for x, single_line in enumerate(file):
		temp_line = single_line.strip()

		# handle empty lines
		if len(temp_line) == 0:
			continue

		# handle octothorpe comments
		if temp_line.startswith('#'):
			continue

		# handle triple single quote encapsulated strings
		if triple_single_quote:
			if temp_line.endswith(T_S_Q):
				triple_single_quote = False
			continue
		elif temp_line.startswith(T_S_Q):
			triple_single_quote = True
			continue
		elif len(re.findall(T_S_Q, temp_line)) % 2 != 0:
			triple_single_quote = True
			continue

		# handle triple double quote encapsulated strings
		if triple_double_quote:
			if temp_line.endswith(T_D_Q):
				triple_double_quote = False
			continue
		elif temp_line.startswith(T_D_Q):
			triple_double_quote = True
			continue
		elif len(re.findall(T_D_Q, temp_line)) % 2 != 0:
			triple_double_quote = True
			continue

		# handle forward slash
		if previous_slash:
			temp_line = previous_line + ' ' + temp_line
			previous_line = ''

		if temp_line.endswith('\\'):
			strip_line = temp_line[:-1]
			previous_line = strip
			_line
			previous_slash = True
			continue
		else:
			strip_line = temp_line

		# set re-used variables
		len_line = len(single_line)
		len_strip_line = len(strip_line)
		len_lstrip_line = len(single_line.lstrip())

		temp_encapsulated = strip_line
		temp_encapsulated = regex_string_splitter(T_S_Q, temp_encapsulated)
		temp_encapsulated = regex_string_splitter(T_D_Q, temp_encapsulated)

		temp_encapsulated = re.sub(REGEX_TEXT, '', temp_encapsulated)

		if temp_encapsulated:
			temp_encapsulated = regex_string_splitter("'", temp_encapsulated)
			temp_encapsulated = regex_string_splitter('"', temp_encapsulated)

			temp_bracket = re.sub(REGEX_BRACKET,'',temp_encapsulated)
			if len(temp_bracket) > 0 or open_bracket_count != 0:
				open_bracket_count += (len(re.sub(REGEX_LBRACKET,'',temp_encapsulated)) - len(re.sub(REGEX_RBRACKET,'',temp_encapsulated)))

			temp_brace = re.sub(REGEX_BRACE,'',temp_encapsulated)
			if len(temp_brace) > 0 or open_brace_count != 0:
				open_brace_count += (len(re.sub(REGEX_LBRACE,'',temp_encapsulated)) - len(re.sub(REGEX_RBRACE,'',temp_encapsulated)))

			temp_paren = re.sub(REGEX_PAREN,'',temp_encapsulated)
			if len(temp_paren) > 0 and open_paren_count != 0:
				open_paren_count += (len(re.sub(REGEX_LPAREN,'',temp_encapsulated)) - len(re.sub(REGEX_RPAREN,'',temp_encapsulated)))

		# no indent
		if len_line == len_lstrip_line:
			indent_count = 0

		# indent exists
		elif len_line != len_lstrip_line and open_bracket_count == 0 and open_brace_count == 0 and open_paren_count == 0:
			# set indent pattern
			if not indent_character:
				indent_character = single_line[:(len_line - len_lstrip_line)]

			# indent matches immediately after semi-colon
			elif semi_colon_set:
				if (indent_character * indent_count) != single_line[:(len_line - len_lstrip_line)]:
					raise ValueError('line', x + 1, 'Inconsistency in indentation from line to line')
			else:
				indent_len = len(indent_character)
				raw_indent = single_line[:(len_line - len_lstrip_line)]
				raw_indent_len = len(raw_indent)

				for y in range(0,raw_indent_len):
					if raw_indent[y:(y + indent_len)] != indent_character:
						raise ValueError('line', x + 1, 'Indentation characters inconsistent with previous indentation characters')
					indent_count = y + indent_len


		# handle functions
		if strip_line.startswith('def'):
			open_function = True
			open_function_indent.append(indent_count)
		elif open_function and len(open_function_indent) > 0:
			if open_function_indent[-1] >= indent_count:
				open_function_indent.pop()
				if len(open_function_indent) == 0:
					open_function = False

		if previous_return[0] and previous_return[1] <= indent_count:
			raise ValueError('line', x + 1, 'Can not be indented as same or higher level than previous return statment')


		# handle returns
		if strip_line.startswith('return'):
			previous_return = (True, indent_count)
			if open_function:
				indent_count -= 1 if indent_count > 0 else 0
				open_function_indent.pop()
				if len(open_function_indent) == 0:
					open_function = False
			else:
				raise ValueError('line', x + 1, 'Return indentation is inconsistent with function')
		else:
			previous_return = (False, 0)

		# handle semi-colons
		if strip_line.endswith(':'):
			indent_count += 1
			semi_colon_set = True
		else:
			semi_colon_set = False

if triple_single_quote or triple_double_quote:
	raise ValueError('Commented sections never closed')

print('success', x + 1, 'lines')
