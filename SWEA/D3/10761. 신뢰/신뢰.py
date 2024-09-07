
def operate(robot, time):
    dist = abs(int(arr[i + 1]) - robot["current"])
    if time == robot["time"]:
        time[0] += dist + 1

    else:
        if dist + robot["time"] > time[0]:
            time[0] += dist - time[0] + robot["time"] + 1
        else:
            time[0] += 1

    robot["time"] = time[0]
    robot["current"] = int(arr[i + 1])

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    arr = input().split()

    n = int(arr[0])

    b = {"current": 1, "time": 0}
    o = {"current": 1, "time": 0}

    time = [0]

    for i in range(len(arr)):
        if arr[i] == 'B':
            operate(b, time)

        elif arr[i] == 'O':
            operate(o, time)

    print(f'#{test_case} {time[0]}')