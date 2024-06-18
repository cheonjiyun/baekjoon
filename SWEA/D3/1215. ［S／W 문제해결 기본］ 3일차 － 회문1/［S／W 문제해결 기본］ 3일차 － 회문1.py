for test_case in range(1, 11):
    result = 0

    N = int(input())
    arr = []
    for i in range(8):
        row = list(input())
        arr.append(row)

    for i in range(8):
        for j in range(8):
            if j <= 8 - N:
                # 가로를 비교
                row = arr[i][j: j+N]
                if row == list(reversed(row)):
                    result += 1
            if i <= 8 - N:
                # 세로를 비교
                col = []
                for c in range(N):
                    col.append(arr[i+c][j])
                if col == list(reversed(col)):
                    result += 1

    print(f'#{test_case} {result}')