
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())

    for i in range(1, 10000000000):
        y = i
        x = i + n

        isCompositeNumberX = False
        isCompositeNumberY = False
        for i in range(2, int(y ** 1/2)):
            # y가 합성수인지
            if y % i == 0:
                isCompositeNumberY = True
            # x가 합성수인지
            if x % i == 0:
                isCompositeNumberX = True

        if isCompositeNumberX and isCompositeNumberY:
            print(f"#{test_case} {x} {y}")
            break
