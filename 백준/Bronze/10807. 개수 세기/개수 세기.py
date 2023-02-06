import sys

N = int(sys.stdin.readline())

list = list(map(int, sys.stdin.readline().split()))

v = int(sys.stdin.readline())
print(list.count(v))
