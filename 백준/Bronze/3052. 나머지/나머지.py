import sys

list = []
count = 10
for i in range(10):
    x = int(sys.stdin.readline())
    remain = x % 42

    if remain in list: #지금까지 입력한 숫자중에 겹치는 숫자가 있는가?
        count -= 1

    list.append(remain)

print(count)


