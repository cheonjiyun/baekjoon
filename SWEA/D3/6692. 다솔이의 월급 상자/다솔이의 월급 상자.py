T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())

    avg = 0
    for _ in range(N):
        p, x = input().split(' ')
        avg += float(p) * int(x)

    print(f"#{test_case} {avg}")
