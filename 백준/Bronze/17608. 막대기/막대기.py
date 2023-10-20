import sys
input = sys.stdin.readline

def solution(sticks):
    longL = sticks[-1]
    answer = 1
    for i in range(len(sticks)-2, -1, -1):
        if longL < sticks[i]:
            longL = sticks[i]
            answer += 1            
    return answer

n = int(input())
arr = []
for i in range(n):
    arr.append(int(input()))
    
print(solution(arr))
            