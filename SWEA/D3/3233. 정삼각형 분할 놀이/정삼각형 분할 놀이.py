def theNumberOf(n):
    return 2 * n - 1

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):

    a, b = map(int, input().split())

    case = a / b

    count = (1 + theNumberOf(case)) * (case / 2)

    print(f"#{test_case} {int(count)}")
