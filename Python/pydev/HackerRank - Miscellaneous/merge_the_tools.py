from collections import OrderedDict

def merge_the_tools(string, k):
	int_i = 0
	int_t = k
	for i in range(len(string)//k):
		print("".join(OrderedDict.fromkeys(string[int_i:int_t]).keys()))
		int_i += k
		int_t += k
