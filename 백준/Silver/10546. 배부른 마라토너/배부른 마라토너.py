import sys
input = sys.stdin.readline

def solution(names):
    cnt = dict()
    for x in names:
        if x in cnt:
            cnt[x] += 1
        else:
            cnt[x] = 1

    for key in cnt:
        if cnt[key] % 2 == 1:
            return key


names = []
N = int(input())
for i in range(N + N-1):
    names.append(input())

print(solution(names))
