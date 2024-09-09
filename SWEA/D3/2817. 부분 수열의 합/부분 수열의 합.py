def dfs(arr, i, n, k, number):
    if number == k:
        return 1
    if number > k:
        return 0

    result = 0
    for j in range(i+1, n):
        result += dfs(arr, j, n, k, number + arr[j])

    return result

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))

    arr.sort()

    answer = 0
    for i in range(n):
        answer += dfs(arr, i, n, k, arr[i])

    print(f"#{test_case} {answer}")
