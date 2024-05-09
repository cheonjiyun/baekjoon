T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):

    N, M = map(int, input().split())

    #배열
    arr = []
    for _ in range(N):
        arr.append(list(map(int, input().split())))

    #배열 순회
    maxCount = 0
    # 모든 경우를 돌면서
    for j in range(N - M + 1):
        for i in range(N - M + 1):
            # 파리채영역
            current = 0
            for x in range(i, i + M):
                for y in range(j, j + M):
                    current += arr[y][x]

            if maxCount < current:
                maxCount = current

    print(f"#{test_case} {maxCount}")