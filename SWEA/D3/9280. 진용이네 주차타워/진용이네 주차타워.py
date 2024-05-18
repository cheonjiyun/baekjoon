
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    feeArr = [int(input()) for _ in range(n)]
    weightArr = [int(input()) for _ in range(m)]
    orderArr = [int(input()) for _ in range(m * 2)]

    currentPlace = [0 for _ in range(n)]
    waiting = []
    money = 0
    for x in orderArr:
        # 차량이 들어옴
        if x > 0:
            # 대기줄에 넣기
            waiting.append(x)

        #차량이 나감
        else:
            # 차 빼기
            currentPlace[currentPlace.index(abs(x))] = 0

        # 대기중인 차량이 있으면 넣기
        if len(waiting) > 0:
            for p in range(len(currentPlace)):
                # 자리가 있음
                if currentPlace[p] == 0:
                    car = waiting.pop(0)
                    # 넣기
                    currentPlace[p] = car
                    # 요금계산
                    money += weightArr[car-1] * feeArr[p]
                    break

    print(f"#{test_case} {money}")