def solution(n, m, name):
    answer = []
    cnt = dict()
    for i in name:
        if i in cnt:
            cnt[i] += 1
        else:
            cnt[i] = 1
            
    for key in cnt:
        if cnt[key] == 2:
            answer.append(key)
        
    print(len(answer))
    for i in sorted(answer):
        print(i)



name = []
N, M = map(int, input().split())
for i in range(N+M):
    name.append(input())
    
solution(N, M, name)