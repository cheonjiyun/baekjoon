import sys

X = int(sys.stdin.readline())

i = 0
sum = 0
while sum < X:
    i += 1
    sum += i

if i % 2 == 0:
    print("%d/%d" % (i - (sum - X), (sum - X) + 1))
else:
    print("%d/%d" % ((sum - X) + 1, i - (sum - X)))


