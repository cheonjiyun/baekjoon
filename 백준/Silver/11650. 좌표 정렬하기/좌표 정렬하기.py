def solution(arr):
    arr.sort(key = lambda v : (v[0], v[1]))
    
    for i in arr:
        print(i[0], i[1])
    
    

N = int(input())
arr = []
for _ in range(N):
    x, y = map(int, input().split())
    arr.append([x, y])

solution(arr)