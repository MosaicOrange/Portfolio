qty = int(input())
phoneBook = {}

for i in range(qty):
    key_value = ((input().strip()).split(" "))
    phoneBook[key_value[0]] = int(key_value[1])

try:
	while(True):
		i = input().strip()
		if i in phoneBook:
			print(i + "=" + str(phoneBook.get(i)))
		else:
			print("Not found")
except: 
	pass