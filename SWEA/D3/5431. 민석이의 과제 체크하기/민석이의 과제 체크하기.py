T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, T = map(int, input().split())
    sub = list(map(int, input().split(' ')))

    students = [0 for i in range(N)]

    for s in sub:
        students[s - 1] = 1

    result = ""
    for i in range(N):
        if students[i] == 0:
            result += f" {i+1}"
    print(f"#{test_case}{result}")