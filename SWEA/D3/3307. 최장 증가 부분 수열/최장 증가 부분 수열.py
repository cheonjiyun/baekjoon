T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())

    arr = list(map(int, input().split()))
    d = []

    for i in range(n):
        maxL = 0
        for j in range(0, i):
            if arr[j] < arr[i]:
                maxL = max(maxL, d[j])

        d.append(maxL + 1)

    print(f"#{test_case} {max(d)}")