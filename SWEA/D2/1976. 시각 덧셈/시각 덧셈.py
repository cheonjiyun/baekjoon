T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    m1, s1, m2, s2 = map(int, input().split())

    minutes = m1 + m2
    second = s1 + s2

    minutes += second // 60
    second = second % 60

    if minutes > 12:
        minutes = minutes - 12


    print(f"#{test_case} {minutes} {second}")