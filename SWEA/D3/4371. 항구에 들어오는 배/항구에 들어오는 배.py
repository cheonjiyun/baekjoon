T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())
    joyDays = [int(input()) for _ in range(n)]
    copyJoyDays = [joyDays[i] for i in range(len(joyDays))]

    copyJoyDays.pop(0)
    first = 1
    result = 0
    while len(copyJoyDays):
        diff = copyJoyDays[0] - first
        i = 1

        # 배수를 다 제거
        while True:
            times = diff * i
            number = first + times

            if number in joyDays:
                if number in copyJoyDays:
                    copyJoyDays.remove(number)
            else:
                break
            i += 1

        result += 1
    print(f"#{test_case} {result}")