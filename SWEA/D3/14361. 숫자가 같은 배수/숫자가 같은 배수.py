T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())
    numbers = list(str(n))

    result = 'impossible'
    i = 2
    while True:
        nTime = str(n * i)
        if len(nTime) > len(numbers):
            break
        for number in numbers:
            nTime = nTime.replace(number, '', 1)


        if nTime == '':
            result = 'possible'
            break

        i += 1

    print(f"#{test_case} {result}")
