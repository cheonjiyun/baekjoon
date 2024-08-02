T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())
    p = list(map(int, input().split(' ')))

    count = 0
    for i in range(1, len(p) - 1):
        group = p[i-1:i+2]
        maxValue = max(group)
        minValue = min(group)

        if p[i] != minValue and p[i] != maxValue:
            count += 1

    print(f"#{test_case} {count}")