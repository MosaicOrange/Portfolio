import math
def is_prime(some_number):
    if some_number == 2:
        return True
    elif some_number <= 1:
        return False
    else:
        for n in range(2,math.ceil(math.sqrt(some_number))+1):
            if some_number%n == 0:
                return False
        else:
            return True

total_input = int(input().strip())
for _ in range(total_input):
    if is_prime(int(input().strip())):
        print("Prime")
    else:
        print("Not prime")
