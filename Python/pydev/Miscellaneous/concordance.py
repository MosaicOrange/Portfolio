#!/bin/python3
import re, sys, collections
from pathlib import Path

the_file = None

try:
	# returns an index out of bound error if empty
	the_file = Path(sys.argv[1])
except IndexError as e:
	# using Path allows use of .is_file() which is needed later
	the_file = Path(input("Please give me a file!").strip())
	pass

# prevents passing invalid options to the with open statement
if the_file.is_file():
	concordance_dictionary = dict()
	# closes the resource after use
	with open(the_file) as fp:
		sentence_number = 1
		paragraph_number = 1
		for line in fp:
			# for cases where there are lines of input separated by null space, byasses unnecessary logic
			if line.strip() is "" or line.strip() is None:
				continue
			for key in line.strip().split(" "):
				# done to bypass logic in case of null value
				if key is "":
					continue
				# regex to keep only the letters in lowercase
				# sorting is affected by capitalization 
				tmp_value = str(re.sub(r"\W+", "", key.lower()))
				if tmp_value not in concordance_dictionary:
					tmp_list = [1, [sentence_number], [paragraph_number]]
					concordance_dictionary[tmp_value] = tmp_list
				elif tmp_value in concordance_dictionary:
					tmp_list = concordance_dictionary[tmp_value]
					tmp_list[0] += 1
					tmp_list[1].append(sentence_number)
					tmp_list[2].append(paragraph_number)
					concordance_dictionary[tmp_value] = tmp_list
				# This checks for punctuation to determine the end of a sentence
				# will conflict with titles like Dr. or Mrs.
				if key.endswith(".") or key.endswith("!") or key.endswith("?"):
					sentence_number += 1
			if line.strip() is not "" or line.strip() is not None:
				paragraph_number += 1
	# Python doesn't and can't store regular dictionaries in an ordered format, hence the ordered dictionary
	ordered_dictionary = collections.OrderedDict(sorted(concordance_dictionary.items()))
	for key in ordered_dictionary:
		print(key, "|->", ordered_dictionary[key])
else:
	print("No valid file given, exiting")
	sys.exit()





