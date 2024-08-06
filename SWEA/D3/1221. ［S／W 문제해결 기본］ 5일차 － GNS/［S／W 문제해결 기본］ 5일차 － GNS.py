T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for _ in range(1, T + 1):
    test_case, n = input().split()
    arr = list(input().split())

    gnsToNumber = {
        "ZRO": 0,
        "ONE": 1,
        "TWO": 2,
        "THR": 3,
        "FOR": 4,
        "FIV": 5,
        "SIX": 6,
        "SVN": 7,
        "EGT": 8,
        "NIN": 9,
    }

    gnsToStr = {
        0: "ZRO",
        1: "ONE",
        2: "TWO",
        3: "THR",
        4: "FOR",
        5: "FIV",
        6: "SIX",
        7: "SVN",
        8: "EGT",
        9: "NIN",
    }

    for i in range(int(n)):
        arr[i] = int(gnsToNumber[arr[i]])

    arr.sort()

    for i in range(int(n)):
        arr[i] = gnsToStr[arr[i]]

    print(test_case)
    print(' '.join(arr))