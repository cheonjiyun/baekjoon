def squre(x, n):
    if n == 1:
        return x
    return x * squre(x, n-1)

# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for _ in range(10):
    test_case = int(input())
    N, M = map(int, input().split())

    print(f'#{test_case} {squre(N, M)}')