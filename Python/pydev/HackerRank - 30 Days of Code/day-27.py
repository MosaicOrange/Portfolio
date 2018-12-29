from random import randint

total_scenarios = randint(0,5)
print(total_scenarios)
for x in range(total_scenarios):
	n = randint(3,200)
	k = randint(1,n)
	print(n,k)
	print(randint(-1000,-1), 0, randint(1,1000), end=" ")
	if (n-3) != 0:
		for y in range(n-3):
			print(randint(-1000,1000), end=" ")
	print("")