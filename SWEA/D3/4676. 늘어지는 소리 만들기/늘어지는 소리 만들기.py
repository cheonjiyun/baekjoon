T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    strings = input()
    h = int(input())
    location = list(map(int, input().split()))

    locationDic = {}
    for i in location:
        if i in locationDic:
            locationDic[i] += 1
        else:
            locationDic[i] = 1

    result = ""
    l = len(strings)
    for i in range(l+1):
        if i in locationDic:
            for _ in range(locationDic[i]):
                result += "-"

        if i < l:
            result += strings[i]

    print(f"#{test_case} {result}")