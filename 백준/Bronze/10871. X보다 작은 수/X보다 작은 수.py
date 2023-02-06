import sys

N, X = map(int, sys.stdin.readline().split())

list = list(map(int, sys.stdin.readline().split()))

small_list = []
for i in list:
    if i < X:
        small_list.append(i)

print(*small_list)