import sys

n = int(input().strip())

value = 0
for v in (str(bin(n)[2:]).split("0")):
	if len(v) > value:
		value = len(v)
print(value)