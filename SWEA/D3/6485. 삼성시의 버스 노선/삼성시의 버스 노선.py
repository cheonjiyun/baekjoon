T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())
    routes = [list(map(int, input().split())) for _ in range(n)]
    p = int(input())
    j = [int(input()) for _ in range(p)]

    busStop = [0 for _ in range(5001)]

    for a, b in routes:
        for i in range(a, b+1):
            busStop[i] += 1

    result = [str(busStop[i]) for i in j]

    print(f"#{test_case} {' '.join(result)}")