T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    clapPeople = list(map(int, input()))

    clapCount = 0
    howHire = 0
    for i in range(len(clapPeople)):
        if clapCount < i:
            how = i - clapCount
            howHire += how
            clapCount += how
        clapCount += clapPeople[i]

    print(f"#{test_case} {howHire}")