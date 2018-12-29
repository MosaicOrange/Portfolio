import sys

t = int(input().strip())
for _ in range(t):
	n,k = [int(x) for x in input().strip().split(" ")]
	tmp_val = 0
	if (k-1) | k <= n:
		print(k-1)
	else:
		print(k-2)