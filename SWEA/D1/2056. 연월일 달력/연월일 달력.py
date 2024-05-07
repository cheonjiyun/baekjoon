T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    calendar_string = input()
    year = calendar_string[0:4]
    month = calendar_string[4:6]
    day = calendar_string[6:8]

    day28 = [2]
    day30 = [4, 6, 9, 11]
    day31 = [1, 3, 5, 7, 8, 10, 13]

    if (int(month) in day28 and 1 <= int(day) <= 28) or (int(month) in day30 and 1 <= int(day) <= 30) or (int(month) in day31 and 1 <= int(day) <= 31):
        result = year + '/' + month + '/' + day
    else:
        result = -1

    print(f"#{test_case} {result}")