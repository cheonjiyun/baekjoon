import sys

number = int(sys.stdin.readline())

sum = 1
count = 1
while sum < number:
    sum = sum + (count * 6)
    count += 1

print(count)
