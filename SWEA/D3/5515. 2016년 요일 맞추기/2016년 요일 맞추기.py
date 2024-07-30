T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    m, d = map(int, input().split())

    monthday = {
        1: 31,
        2: 29,
        3: 31,
        4: 30,
        5: 31,
        6: 30,
        7: 31,
        8: 31,
        9: 30,
        10: 31,
        11: 30,
        12: 31,
    }

    day = 3
    for i in range(1,m):
        day += monthday[i]
    day += d
    day %= 7

    print(f"#{test_case} {day}")