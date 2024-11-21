T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    a, b, c = map(int, input().split())

    result = 0
    if b >= c:
        result += b - c + 1
        b = c - 1
    if a >= b:
        result += a - b + 1
        a = b - 1

    if a <= 0 or b <= 0:
        result = -1

    print(f"#{test_case} {result}")