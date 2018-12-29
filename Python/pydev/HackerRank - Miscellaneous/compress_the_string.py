x = input().strip() + "x"

return_list = list()
last_value = ""
tmp_inc = 1
for c in x:
    if c is "x":
        return_list.append((tmp_inc, int(last_value)))
        break
    if last_value:
        if int(last_value) == int(c):
            tmp_inc += 1
        else:
            return_list.append((tmp_inc, int(last_value)))
            last_value = c
            tmp_inc = 1
    else:
        last_value = c

for x in return_list:
    print(x, end=" ")