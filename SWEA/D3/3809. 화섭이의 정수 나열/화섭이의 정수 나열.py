T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())
    d = ""

    while len(d) < n:
        d +=  "".join(input().split())

    # 숫자 처음부터 다 셈
    count = 0
    numbers = []
    result = False

    while True:
        if str(count) not in d:
            break
        count += 1

    # 출력
    print(f"#{test_case} {count}")