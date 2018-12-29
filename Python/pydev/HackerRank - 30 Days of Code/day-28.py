
import sys
list_of_names = list()

N = int(input().strip())
for _ in range(N):
	firstName,emailID = input().strip().split(" ")
	if "@gmail.com" in emailID:
		list_of_names.append(firstName)

print(*sorted(list_of_names), sep="\n")
