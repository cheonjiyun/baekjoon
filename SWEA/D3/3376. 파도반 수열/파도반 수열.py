T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())

    arr = [1, 1, 1]

    for i in range(3, n):
        arr.append(arr[i-2] + arr[i-3])

    print(f"#{test_case} {arr[n-1]}")
