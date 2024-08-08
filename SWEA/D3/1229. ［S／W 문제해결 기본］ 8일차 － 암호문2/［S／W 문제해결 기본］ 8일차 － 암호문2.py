for test_case in range(1, 11):
    n = int(input())
    ciphertext = list(input().split())
    count = int(input())
    commands = list(input().split())

    for i in range(len(commands)):
        if commands[i] == 'I':
            x = int(commands[i+1])
            y = int(commands[i+2])
            s = commands[i+3:i+3 + y]
            for j in range(y):
                ciphertext.insert(x+j, s[j])

        if commands[i] == 'D':
            x = int(commands[i+1])
            y = int(commands[i+2])

            for _ in range(y):
                ciphertext.pop(x) # 삭제되니까 +j없이 그자리에서 y번 삭제해야함

    print(f"#{test_case} {' '.join(ciphertext[:10])}")
