# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, 11):
    n, password = input().split()

    while 1:
        end = True
        # 겹치는 문자가 있다면
        for i in range(len(password) - 1):
            if password[i] == password[i+1]:
                password = password[:i] + password[i+2:]
                end = False # 있다.
                break # 다시 처음부터 돈다
        if end: #없다
            break

    print(f"#{test_case} {password}")

