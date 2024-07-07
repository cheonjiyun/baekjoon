
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())

    farm = []

    for i in range(n):
        farm.append(list(map(int, input())))
    
    # y는 전체를 돌고 x를 밖에 변수를 두어서 범위를 지정해준다.
    xs = n // 2
    xe = n // 2

    # 늘린건지 줄일건지
    d = 1

    count = 0
    for y in range(n):
        for x in range(xs, xe + 1):
            count += farm[y][x]

        # 범위를 늘린다.
        xs -= d
        xe += d
        # 첫범위가 0이 되는순간 다시 줄어든다
        if xs == 0:
            d = -1

    print(f"#{test_case} {count}")

