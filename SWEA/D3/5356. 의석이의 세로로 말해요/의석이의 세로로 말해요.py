T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    arr = [list(input()) for _ in range(5)]

    maxLength = max(len(x) for x in arr)

    result = ""

    for i in range(maxLength):
        for x in range(5):
            try:
                result += arr[x][i]
            except IndexError:
                '예외'
        
    print(f"#{test_case} {result}")