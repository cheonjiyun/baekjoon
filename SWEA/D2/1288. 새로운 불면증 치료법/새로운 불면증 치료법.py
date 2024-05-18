T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())
    numbers = []

    count = 1
    number = 1
    while len(numbers) < 10:

        # 숫자 n곱
        number = n * count
        count += 1

        # 숫자 세기
        for s in str(number):
            if s not in numbers:
                numbers.append(s)

    print(f"#{test_case} {number}")