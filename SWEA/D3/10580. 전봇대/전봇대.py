T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]

    answer = 0

    for i in range(n):
        for another in range(i, n):
                if (arr[i][0] < arr[another][0] and arr[i][1] > arr[another][1]) or (arr[i][0] > arr[another][0] and arr[i][1] < arr[another][1]):
                    #a 위에있는으면서 b 아래있음 or b 아래있으면서 b위에있음
                    answer += 1

    print(f"#{test_case} {answer}")