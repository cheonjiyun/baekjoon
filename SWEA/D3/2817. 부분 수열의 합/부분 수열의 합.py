def dfs(arr, i, n, k, number):
    if number == k:
        return 1
    if number > k:
        return 0
    if i == n:
        return 0

    result = 0
    result += dfs(arr, i+1, n, k, number)
    result += dfs(arr, i+1, n, k, number + arr[i])
    return result

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))

    answer = dfs(arr, 0, n, k, 0)

    print(f"#{test_case} {answer}")