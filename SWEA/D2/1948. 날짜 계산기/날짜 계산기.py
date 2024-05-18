monthDay = {1: 31, 2: 28, 3:31, 4:30, 5:31, 6:30, 7:31, 8:31, 9:30, 10:31, 11:30, 12:31}

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    m1, d1, m2, d2 = map(int, input().split())

    # 첫번째 날부터 한달씩 채워나간다
    result = 0
    while m1 < m2:
        result += monthDay[m1]
        m1 += 1

    # 막달
    result += d2 - d1 + 1

    print(f"#{test_case} {result}")
