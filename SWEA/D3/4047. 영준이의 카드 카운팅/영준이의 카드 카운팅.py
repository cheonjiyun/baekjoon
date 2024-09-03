T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    s = input()

    cards = [[], [], [], []]
    pattern = ["S", "D", "H", "C"]

    isError = False
    for i in range(0, len(s), 3):
        patternIndex = pattern.index(s[i])

        xy = int(s[i+1] + s[i+2])
        cards[patternIndex].append(xy)

        # 중복확인
        if len(cards[patternIndex]) != len(list(set(cards[patternIndex]))):
            isError = True
            break

    print(f"#{test_case}", end=" ")
    if isError:
        print("ERROR", end=" ")
    else:
        for card in cards:
            print(13 - len(card), end=' ')
    print()