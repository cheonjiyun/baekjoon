encodingArr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/'
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    sentence = input()

    # 2진수로 변환
    binarySentence = ''
    for s in sentence:
        binaryNumber = format(encodingArr.index(s), "b")

        while len(binaryNumber) < 6:
            binaryNumber = '0' + binaryNumber

        binarySentence += binaryNumber

    n = len(binarySentence)
    result = ''
    for i in range(0, n, 8):
        #10진수로 변환
        decNumber = 0
        if i+8 > n:
            decNumber = int(binarySentence[i: n], 2)
        else:
            decNumber = int(binarySentence[i: i+8], 2)
        #아스키코드 변환
        result += chr(decNumber)

    print(f"#{test_case} {result}")
