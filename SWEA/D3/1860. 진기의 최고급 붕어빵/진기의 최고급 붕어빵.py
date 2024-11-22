T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n, m, k = map(int, input().split())
    customer = list(map(int, input().split()))
    customer.sort()

    result = "Possible"

    for i in range(n):
        # 본인 차례가 왔을 때 만들 수 있는 개수 - 앞사라미 가져간 개수
        if (customer[i] // m) * k - i <= 0:
            result = "Impossible"
            break

    print(f"#{test_case} {result}")