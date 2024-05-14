T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]

    print(f"#{test_case}")
    # 90도
    for i in range(N):
        x = 0 + i
        y = N-1
        for _ in range(N):
            print(arr[y][x], end='')
            y -= 1
        print('',end=' ')

        # 180도
        x = N-1
        y = N-1 - i
        for _ in range(N):
            print(arr[y][x], end='')
            x -= 1
        print('',end=' ')

        # 270도
        x = N-1 - i
        y = 0
        for _ in range(N):
            print(arr[y][x], end='')
            y += 1
        print('',end=' ')

        print('')
