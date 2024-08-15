T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    d, h, m = map(int, input().split())

    promise = 60 * 24 * 11 + 60 * 11 + 11
    realization = 60 * 24 * d + 60 * h + m

    waiting = realization - promise
    if waiting < 0:
        waiting = -1
    print(f"#{test_case} {waiting}")