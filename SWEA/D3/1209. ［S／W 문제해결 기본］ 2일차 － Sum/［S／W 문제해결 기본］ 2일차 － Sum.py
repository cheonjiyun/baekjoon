# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for _ in range(10):
    test_case = int(input())

    arr = [list(map(int, input().split())) for _ in range(100)]

    maxValue = 0

    # 가로
    for row in arr:
        sumValue = sum(row)
        if sumValue > maxValue:
            maxValue = sumValue

    # 세로
    for x in range(100):
        sumValue = 0
        for y in range(100):
            sumValue += arr[y][x]
        if sumValue > maxValue:
            maxValue = sumValue

    # 대각선 좌상 -> 우하
    sumValue = 0
    for i in range(100):
        sumValue += arr[i][i]
    if sumValue > maxValue:
        maxValue = sumValue

    # 개각선 우상 -> 좌하
    sumValue = 0
    for y in range(100):
        for x in range(99, -1, -1):
            arr[y][x]
    if sumValue > maxValue:
        maxValue = sumValue

    print(f"#{test_case} {maxValue}")