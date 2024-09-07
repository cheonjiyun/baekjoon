T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    d, l, n = map(int, input().split())

    answer = 0

    for i in range(n):
        answer += d * (1 + i * (l * (1 / 100)))

    print(f"#{test_case} {int(answer)}")