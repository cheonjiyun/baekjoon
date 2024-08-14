# 좌표 -> 숫자
# (1,1) => 1
# (2,1) => 2
# (3,1) => 4
# (4,1) => 7
def numberToCoordinate(x, y):
    # y-1까지 파란줄개수
    sumNumber = 0
    for i in range(1, y + x - 1):
        sumNumber += i
    return sumNumber + x

# 1, 3, 6, 10
def coordinateToNumber(number):
    # 등사수열 합을 거꾸로 구함
    # 해당 파란 줄의 첫번째 y 좌표
    sumNumber = 0
    plusNumber = 1
    y = 1
    while sumNumber < number:
        if sumNumber + plusNumber < number:
            y += 1
            sumNumber += plusNumber
            plusNumber += 1
        else:
            break
    sumNumber += 1

    # 파란 줄에서 이동
    x = 1
    for _ in range(number - sumNumber):
        y -= 1
        x += 1

    return [x, y]


T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    p, q = map(int, input().split())

    [x, y] = coordinateToNumber(p)
    [z, w] = coordinateToNumber(q)

    result = numberToCoordinate(x + z, y + w)
    print(f"#{test_case} {result}")