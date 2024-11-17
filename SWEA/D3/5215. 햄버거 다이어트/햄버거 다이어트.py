T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n, l = map(int, input().split())
    tk = [list(map(int, input().split())) for i in range(n)]

    maxScore = 0
    for caseNumber in range(1 << n):
        happy = 0
        cal = 0
        for i in range(n):
            if caseNumber & 1 << i:
                happy += tk[i][0]
                cal += tk[i][1]

        if cal <= l and happy > maxScore:
            maxScore = happy

    print(f"#{test_case} {maxScore}")