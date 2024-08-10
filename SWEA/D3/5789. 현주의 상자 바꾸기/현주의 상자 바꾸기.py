T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n, q = map(int, input().split())

    arr = ['0' for _ in range(n)]

    for i in range(1,q+1):
        l, r = map(int, input().split())

        for j in range(l-1, r):
            arr[j] = str(i)

    print(f"#{test_case} {' '.join(arr)}")
