T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())

    arr = [list(map(int, input().split())) for _ in range(n)]

    arrSort = [[] for _ in range(n)]
    state = 0
    for x in range(n):
        leftYet = True
        rightYet = True
        for y in range(n):
            # 0은 패스
            if arr[y][x] == 0:
                continue
            # 2가 맨왼쪽에 있으면 패스
            if arr[y][x] == 2 and leftYet:
                continue
            # 1이 되면
            if arr[y][x] == 1:
                # 왼쪽에 막는 애가 생긴거
                leftYet = False

                # 1이 맨 오른쪽에 있으면 패스
                last1 = True
                for i in range(y, n):
                    if arr[i][x] == 2:
                        last1 = False
                        break
                if last1:
                    rightYet = False
                    continue

            # 그제서야 추가
            if state != arr[y][x]:
                arrSort[x].append(arr[y][x])
                state = arr[y][x]

    result = 0
    for a in arrSort:
        result += len(a) // 2

    print(f"#{test_case} {result}")
