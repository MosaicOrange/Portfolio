import sys

n = int(input().strip())
a = list(map(int, input().strip().split(' ')))
# Write Your Code Here

numSwaps = 0
for i in range(n):
    for j in range(n-1):
        if (a[j] > a[j+1]):
            temp_val = a[j]
            a[j] = a[j+1]
            a[j+1] = temp_val
            numSwaps += 1
    if numSwaps == 0:
        break

print("Array is sorted in", numSwaps, "swaps.")
print("First Element:", a[0])
print("Last Element:", a[len(a)-1])