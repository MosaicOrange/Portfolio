import sys

sys.stdin.readline()
array_N = sys.stdin.readline().strip().split(" ")
set_A = set(sys.stdin.readline().strip().split(" "))
set_B = set(sys.stdin.readline().strip().split(" "))

value = 0
for n in array_N:
    if n in set_A:
        value += 1
    elif n in set_B:
        value -= 1

print(value)
