#!/bin/python3
import sys

arr = []
first_dimension = 0
for arr_i in range(6):
    arr_t = [int(arr_temp) for arr_temp in input().strip().split(' ')]
    if first_dimension == 0:
        first_dimension = len(arr_t)
    arr.append(arr_t)

ret_val = 0
for i in range(len(arr) - 2):
	for a in range(first_dimension - 2):
		tmp_val = sum([arr[i][a], arr[i][a+1], arr[i][a+2], arr[i+1][a+1], arr[i+2][a], arr[i+2][a+1], arr[i+2][a+2]])
		if i == 0 and a == i:
			ret_val = tmp_val
		if tmp_val >= ret_val:
			ret_val = tmp_val

print(ret_val)