N, M = map(int, input().split())

matrix2d_1 = []
matrix2d_2 = []

# 첫 번째 행렬
for row in range(N):
    matrix_row = list(map(int, input().split()))
    matrix2d_1.append(matrix_row)

# 두 번 째 행렬
for row in range(N):
    matrix_row = list(map(int, input().split()))
    matrix2d_2.append(matrix_row)

# 덧셈
for row in range(N):
    for col in range(M):
        print(matrix2d_1[row][col] + matrix2d_2[row][col], end=' ')
    print("")
