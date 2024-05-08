T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    strings = input()

    #단어 찾기
    word = ''
    for s in range(len(strings) // 2):
        word += strings[s]

        if word == strings[s+1:s+len(word)+1]:
            break

    print(f"#{test_case} {len(word)}")