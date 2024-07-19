T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    s = list(input())


    # 공 한쪽이 가려졌을 때 한쪽 표시
    for i in range(len(s)):
        if s[i] == "(":
            s[i+1] = ")"
        elif s[i] == ")":
            s[i-1] = "("

    # 공 개수
    result = 0
    for x in s:
        if x == '(':
            result += 1

    print(f"#{test_case} {result}")
