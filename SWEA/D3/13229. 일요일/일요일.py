dayArr = ["MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"]

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    day = input()

    number = dayArr.index(day)
    number = (number + 1) % 7

    print(f"#{test_case} {7 - number}")