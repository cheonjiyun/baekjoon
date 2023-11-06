import sys

input = sys.stdin.readline

def solution(board, r, c, d):

    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    # 첫 청소
    board[r][c] = 2
    answer = 1

    while True:
        dirty = False

        # 청소 안된 칸을 반시계 90도로 돌며 찾자
        for _ in range(4):
            d = (d + 3) % 4
            nx = r + dx[d]
            ny = c + dy[d]
            if board[nx][ny] == 0: # 청소 안된 칸이 있다.
                r = nx
                c = ny

                # 바로 청소
                answer += 1
                board[nx][ny] = 2
                dirty = True

                break

        # 청소 안된 칸이 없다!
        if not dirty:

            # 후진실패 : 종료
            if board[r-dx[d]][c-dy[d]] == 1:
                return answer

            else:
                r = r - dx[d]
                c = c - dy[d]

    return answer


N, M = map(int, input().split())
r, c, d = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

print(solution(board, r, c, d))

