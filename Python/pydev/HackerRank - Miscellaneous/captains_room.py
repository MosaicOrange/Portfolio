input().strip()

set_a = set()
main_set = set()
a_list = map(int, input().strip().split(" "))

for h in (a_list):
    if h in main_set:
        set_a.add(h)
    else:
        main_set.add(h)

for h in main_set.difference(set_a):
    print(h)
