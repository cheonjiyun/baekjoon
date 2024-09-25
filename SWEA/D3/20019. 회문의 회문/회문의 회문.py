T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    s = input()
    n = len(s)
    isOdd = True if n % 2 == 1 else False

    left = s[:n//2]
    right = s[n//2:]
    if isOdd:
        right = s[n//2 + 1:]


    print(f"#{test_case} {'YES' if s == s[::-1] and left == left[::-1] and right == right[::-1] else 'NO'}" )
