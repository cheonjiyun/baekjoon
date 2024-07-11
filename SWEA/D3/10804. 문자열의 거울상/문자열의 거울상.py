T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    string = list(input())

    result = ""
    for i in range(len(string)-1, -1, -1):
        if string[i] == 'b':
            result += 'd'
        elif string[i] == 'd':
            result += 'b'
        elif string[i] == 'p':
            result += 'q'
        elif string[i] == 'q':
            result += 'p'

    print(f"#{test_case} {result}")