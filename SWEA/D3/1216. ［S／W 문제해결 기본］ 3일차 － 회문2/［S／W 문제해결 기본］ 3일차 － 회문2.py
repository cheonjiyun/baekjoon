# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for _ in range(10):
    test_case = int(input())
    arr = [list(input()) for _ in range(100)]

    result = 0
    for y in range(100):
        for x in range(100):
            word = []
            for ny in range(y, 100):
                word.append(arr[ny][x])
                if word == list(reversed(word)) and result < len(word):
                    result = len(word)

            word = []
            for nx in range(x, 100):
                word.append(arr[y][nx])

                if word == list(reversed(word)) and result < len(word):
                    result = len(word)

    print(f"#{test_case} {result}")
