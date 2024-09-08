T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())

    anaswer = 0
    for i in range(int(n ** (1/2))+1, 0, -1):
        if n % i == 0:
            anaswer = i + n // i - 2
            break

    print(f"#{test_case} {anaswer}")