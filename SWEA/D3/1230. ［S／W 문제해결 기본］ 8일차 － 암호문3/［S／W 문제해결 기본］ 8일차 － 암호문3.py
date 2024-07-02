# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, 11):
    N = int(input())
    ciphertexts = list(map(int, input().split()))
    M = int(input())
    commands = list(input().split())


    # 1. 명령어 단위로 쪼갠다.
    commandsSplit = []
    currentCommand = []
    for c in commands:
        if c == 'I' or c == "D" or c == "A":
            commandsSplit.append(currentCommand)
            currentCommand = []
            currentCommand.append(c)
        else:
            currentCommand.append(int(c))
    commandsSplit.pop(0)

    # 2. 커맨드별 처리
    for c in commandsSplit:
        if c[0] == 'I':
            for i in range(c[2]):
                ciphertexts.insert(c[1] + i, c[3 + i])

        if c[0] == 'D':
            for i in range(c[2]):
                ciphertexts.pop(c[1])

        if c[1] == 'A':
            for i in range(c[1]):
                ciphertexts.append(c[2 + i])

    print(f"#{test_case}", end=' ')
    for i in range(10):
         print(ciphertexts[i], end=' ')
    print()

