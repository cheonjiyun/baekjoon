T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())
    haystack = [int(input()) for _ in range(n)]

    avg = int(sum(haystack) / len(haystack))

    result = 0
    for h in haystack:
        if h < avg:
            result += avg - h

    print(f"#{test_case} {result}")
