T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n, m = map(int, input().split())

    sn = input().split()
    tm = input().split()
    q = int(input())

    y = [int(input()) for _ in range(q)]

    print(f"#{test_case}", end=' ')
    for x in y:
        print(sn[x % n -1] + tm[x % m -1], end=' ')
    print()
