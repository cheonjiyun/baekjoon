
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
dArrow = ['^', '>', 'v', '<']

def getDirection(stringUDLR):
    if stringUDLR == 'U':
        return 0
    if stringUDLR == 'R':
        return 1
    if stringUDLR == 'D':
        return 2
    if stringUDLR == 'L':
        return 3

def getCurrent(gameMap):
    for y in range(h):
        for x in range(w):
            if gameMap[y][x] == '^' or gameMap[y][x] == 'v' or gameMap[y][x] == '<' or gameMap[y][x] == '>':
                return [x, y]


def move(stringUDLR, gameMap, h ,w):
    x, y = getCurrent(gameMap)

    # 회전
    direction = getDirection(stringUDLR)
    gameMap[y][x] = dArrow[direction]

    # 이동할 수 있는지 확인 (범위내, 바닥)
    nx = x + dx[direction]
    ny = y + dy[direction]

    if ny >= 0 and nx >= 0 and ny < h and nx < w and gameMap[ny][nx] == '.':
        # 이동
        gameMap[ny][nx] = gameMap[y][x]
        gameMap[y][x] = '.'

def shooting(gameMap, h, w):
    x, y = getCurrent(gameMap)

    # 지금 방향
    direction = dArrow.index(gameMap[y][x])

    # 벽 탐지
    nx = x + dx[direction]
    ny = y + dy[direction]


    while ny >= 0 and nx >= 0 and ny < h and nx < w:
        # print(gameMap[y][x], nx, ny)
        # print('whildE')
        if gameMap[ny][nx] == '*':
            gameMap[ny][nx] = '.'
            break
        if gameMap[ny][nx] == '#':
            break

        nx += dx[direction]
        ny += dy[direction]


T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    h, w = map(int, input().split())
    gameMap = [list(input()) for _ in range(h)]
    n = int(input())
    commands = list(input())


    # for row in gameMap:
    #     print(row)

    for command in commands:
        # print(command)
        if command == 'S':
            shooting(gameMap, h, w)
        else:
            move(command, gameMap, h ,w)

    # for row in gameMap:
    #     print(row)

    print(f"#{test_case}", end=' ')
    for row in gameMap:
        print(''.join(row))