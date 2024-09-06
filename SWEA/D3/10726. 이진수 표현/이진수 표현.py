
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n, m = map(int, input().split())

    bmarr = []

    result = "ON"
    for _ in range(n):
        if m % 2 == 0:
            result = "OFF"
            break
        m = m // 2

    print(f"#{test_case} {result}")
