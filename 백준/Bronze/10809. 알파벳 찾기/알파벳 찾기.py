import sys

s = list(map(str, sys.stdin.readline().strip()))

#리스트 만들기
index_list = []
for i in range(26):
    index_list.append(-1)

#위치찾아서 넣기
for i in s:
    index_list[ord(i)-97] = s.index(i)

print(*index_list)