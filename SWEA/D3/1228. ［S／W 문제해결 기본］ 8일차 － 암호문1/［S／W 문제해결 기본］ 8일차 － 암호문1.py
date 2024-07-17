def insert(x, y, s, cyper):
    for i in range(y):
        cyper.insert(x+i, s[i])



# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, 11):
    N = int(input())
    cyper = list(input().split(' '))
    count = int(input())
    commands = list(input().split(' '))

    i = 0
    for i in range(len(commands)):
        if commands[i] == 'I':
            x = int(commands[i + 1])
            y = int(commands[i + 2])
            s = commands[i + 3 : i + 3 + y]

            insert(x, y ,s, cyper)


    print(f"#{test_case} {' '.join(cyper[:10])}")
