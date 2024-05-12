T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]

    result = 0
    # 가로
    for i in range(N):
        count = 0
        for x in range(N+1):
            # 검은색을 만나면
            if x == N or arr[i][x] == 0:
                if count == K:
                    result += 1
                count = 0
            else:
                count += 1

        for x in range(N+1):
            # 검은색을 만나면
            if x == N or arr[x][i] == 0:
                if count == K:
                    result += 1
                count = 0
            else:
                count += 1


    print(f"#{test_case} {result}")
