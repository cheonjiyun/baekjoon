T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    L, U, X = map(int, input().split())

    result = 0
    if X > U:
        result = -1
    elif X < L:
        result = L - X

    print(f"#{test_case} {result}")