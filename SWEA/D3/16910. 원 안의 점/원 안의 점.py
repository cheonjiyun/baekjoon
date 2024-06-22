T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())

    count = 0
    # 1사분면 돌면서 x,y 좌표가 반지름 안에 있는지
    for y in range(1, N+1):
        for x in range(1, N+1):
            if x ** 2 + y ** 2 <= N ** 2:
                count += 1

    count *= 4 # 1~4분면
    count += N * 4 # x, y 축
    count += 1 # 원점

    print(f"#{test_case} {count}")