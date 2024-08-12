
cnt = 0

def isPossible(chess, row, x):
    for y in range(row):
        if chess[y] == x or abs(x - chess[y]) == abs(row - y):
            return False
    return True

def nQueen(chess, n, row):
    global cnt

    if row == n:
        cnt += 1
        return

    # 가로 한줄
    for x in range(n):
        # 놓을 수 있느냐
        if isPossible(chess, row, x):
            chess[row] = x
            nQueen(chess, n, row+1)

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())

    chess = [-1 for _ in range(n)]

    cnt = 0
    nQueen(chess, n, 0)

    print(f"#{test_case} {cnt}")


