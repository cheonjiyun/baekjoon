import sys

score = []

N = int(sys.stdin.readline())

score = list(map(int, sys.stdin.readline().split()))

revise = []
for i in score:
    revise.append(i / max(score) * 100)

print(sum(revise) / len(revise))
