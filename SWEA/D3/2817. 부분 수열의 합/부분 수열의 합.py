T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))

    answer =0
    for i in range(0, 1 << n): # 2^n
        # print("i::", bin(i))
        sumNumber = 0
        for j in range(n): # n
            # print('j', j)
            #
            # print('왼', bin(i))
            # print('오', bin(1 << j))
            # print('&', bin(i & (1 << j)))
            # print(int(i & (1 << j)))
            if i & (1 << j):
                # print('if문 통과')
                sumNumber += arr[j]

            # print()
        if sumNumber == k:
            answer += 1

    print(f"#{test_case} {answer}")
