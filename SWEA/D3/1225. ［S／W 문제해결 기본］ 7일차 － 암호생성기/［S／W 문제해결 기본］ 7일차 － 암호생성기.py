# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for _ in range(1, 11):
    test_cast = int(input())
    numbers = list(map(int, input().split()))

    while numbers[7] > 0: # 마지막이 0이 아닐동안 계속 루프
        for i in range(1, 6): # 1~5까지
            minusNumber = numbers[0] - i # 맨 앞에 숫자를 i만큼 뺀다.
            if minusNumber <= 0: # 0미만라면 0으로 바꾸어준다.
                minusNumber = 0

            # 배열 재생성: 맨 앞에 빼고 잘라낸다음, 다시 맨 뒤로 넣어준다.
            numbers = numbers[1:8]
            numbers.append(minusNumber)

            # 만약 0이었으면 증가하는 행동을 그만둔다.
            if minusNumber == 0:
                break

    result = " ".join(map(str, numbers)) # 숫자 리스트를 문자열로 바꾼뒤 join한다.
    print(f"#{test_cast} {result}")