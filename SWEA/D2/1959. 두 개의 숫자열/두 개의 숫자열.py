T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, M = map(int, input().split())

    arrA = list(map(int, input().split()))
    arrB = list(map(int, input().split()))

    longArr = 'A'
    if len(arrA) < len(arrB):
        longArr = 'B'

    result = 0
    for x in range(max(M, N) - min(M, N) + 1):
        mul = 0
        for i in range(min(M, N)):
            if longArr == 'A':
                mul += arrA[i + x] * arrB[i]
            else:
                mul += arrA[i] * arrB[i + x]


        result = max(result, mul)

    print(f"#{test_case} {result}")