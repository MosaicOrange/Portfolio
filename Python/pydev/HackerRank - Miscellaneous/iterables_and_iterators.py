from itertools import combinations

input()
S = input().strip().split(" ")
k = int(input().strip())
some_list = list()
some_value = 0

for y in combinations(S,k):
    if "a" in y:
        some_value += 1
    some_list.append(y)
print(some_value/len(some_list))