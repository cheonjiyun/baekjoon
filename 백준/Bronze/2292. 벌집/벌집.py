import sys

number = int(sys.stdin.readline())

sum = 1
count = 1
for i in range(1, 1000000000):
    if number == 1:
        break

    count += 1
    sum = sum + (i * 6)

    if sum >= number:
        break


print(count)
