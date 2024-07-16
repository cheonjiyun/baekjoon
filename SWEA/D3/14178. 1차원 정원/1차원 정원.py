T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, D = map(int, input().split(' '))

    result = -(-N // (D * 2 + 1)) # 내림을 이용해 마이어스에서 내림하고 다시 변환!

    print(f"#{test_case} {result}")

