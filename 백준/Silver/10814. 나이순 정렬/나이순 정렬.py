def solution(arr):
    arr.sort(key = lambda v : v[0])
    
    for i in arr:
        print(i[0], i[1])

N = int(input())
arr = []
for i in range(N):
    age, name = input().split()
    age = int(age)
    arr.append([age, name])
    
solution(arr)