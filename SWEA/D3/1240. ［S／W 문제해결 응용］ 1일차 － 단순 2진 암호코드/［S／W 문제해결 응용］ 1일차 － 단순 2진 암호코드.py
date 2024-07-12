cipherMap = {
    '0001101': 0,
    '0011001': 1,
    '0010011': 2,
    '0111101': 3,
    '0100011': 4,
    '0110001': 5,
    '0101111': 6,
    '0111011': 7,
    '0110111': 8,
    '0001011': 9,
}

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # 입력받기
    N, M = map(int, input().split())
    arr = [input() for _ in range(N)]

    cipherNumbers = []
    for line in arr:
        # 암호문이 있는 줄 찾아내기
        if line.rfind('1') != -1:
            # 암호코드 인덱스 찾아내기
            endIndex = line.rfind('1')
            startIndex = endIndex - 55

            # 암호숫자 8개 추출
            for i in range(8):
                code = line[startIndex + (i * 7) : startIndex + (i * 7) + 7]
                cipherNumber = cipherMap[code]
                cipherNumbers.append(cipherNumber)

            break

    # 홀수 숫자함 짝수 숫자합
    oddSum = 0
    evenSum = 0
    for i in range(len(cipherNumbers)):
        if i % 2 == 0:
            oddSum += cipherNumbers[i]
        else:
            evenSum += cipherNumbers[i]


    # 검증코드
    verificationCode = oddSum * 3 + evenSum
    verification = verificationCode % 10 == 0

    if not verification:
        result = 0
    else:
        result = oddSum + evenSum

    # 출력
    print(f"#{test_case} {result}")