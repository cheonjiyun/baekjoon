T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    strings = input()

    result = []
    for s in strings:
        if strings.count(s) % 2 == 1:
            result.append(s)

    result = list(set(result))
    result.sort()

    print(f"#{test_case} {'Good' if len(result) == 0 else ''.join(result)}")
