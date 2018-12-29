#!/bin/python3
import sys
from pathlib import Path

the_file = None
the_blob = list()

try:
	# returns an index out of bound error if empty
	the_file = Path(sys.argv[1])
except IndexError as e:
	# using Path allows use of .is_file() which is needed later
	the_file = Path(input("Please give me a file!").strip())
	pass

# prevents passing invalid options to the with open statement
if the_file.is_file():
	# closes the resource after use
	with open(the_file) as fp:
		for line in fp:
			for key in line.strip().split(" "):
				the_blob.append([int(c) for c in key])
else:
	print("No valid file given, exiting")
	sys.exit()


def evaluate_blob(blob_object):
	cell_reads = 0
	cell_top = None
	cell_left = None
	cell_bottom = None
	cell_right = None
	tmp_left = None
	tmp_right = None
	bases_not_set = True

	for x, array_item in enumerate(blob_object):
		if bases_not_set:
			for y, int_item in enumerate(array_item):
				cell_reads += 1
				if int_item != 0:
					bases_not_set = False
					if cell_top is None:
						cell_top = x
					if cell_left is None:
						cell_left = y
						tmp_left = y
					if cell_right is None or cell_right < y:
						cell_right = y
						tmp_right = y
					if cell_bottom is None:
						cell_bottom = x
				elif int_item == 0 and cell_right is not None:
					break
		else:
			# This is for the left side
			if cell_left == tmp_left:
				cell_reads += 1
				if array_item[cell_left] != 0:
					cell_bottom = x
					while cell_left > 0:
						cell_reads += 1
						if array_item[cell_left - 1] != 0:
							cell_left -= 1
							tmp_left = cell_left
						else:
							break
			else:
				while tmp_left < tmp_right:
					cell_reads += 1
					if array_item[tmp_left] == 0:
						tmp_left += 1
					else:
						cell_bottom = x
						break
			
			# This is for the right side
			if cell_right == tmp_right:
				cell_reads += 1
				if array_item[cell_right] != 0:
					cell_bottom = x
					while cell_right < len(array_item) - 1:
						cell_reads += 1
						if array_item[cell_right + 1] != 0:
							cell_right += 1
							tmp_right = cell_right
						else:
							break
			else:
				while tmp_right > tmp_left:
					cell_reads += 1
					if array_item[tmp_right] == 0:
						tmp_right -= 1
					else:
						cell_bottom = x
						break

	print("Cell Reads:", cell_reads)
	print("Top:", cell_top)
	print("Left:", cell_left)
	print("Bottom:", cell_bottom)
	print("Right:", cell_right)



for x in the_blob:
	print(x)

print("------------------------------")
evaluate_blob(the_blob)

