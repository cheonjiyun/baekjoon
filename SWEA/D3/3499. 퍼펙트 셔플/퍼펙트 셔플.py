T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())
    cards = list(input().split())

    mid = len(cards) // 2
    if len(cards) % 2 == 1:
        mid += 1
    left = cards[:mid]
    right = cards[mid:]

    result = []
    for i in range(len(right)):
        result.append(left[i])
        result.append(right[i])

    # 긴쪽 마지막 추가
    if len(cards) % 2 == 1:
        result.append((left[len(left) - 1]))

    print(f"#{test_case} {' '.join(result)}")