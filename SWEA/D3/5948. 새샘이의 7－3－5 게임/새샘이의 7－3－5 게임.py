T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    numbers = list(map(int, input().split()))

    sumNumbers = []
    n = len(numbers)
    for i in range(n):
        for j in range(i+1,n):
            for z in range(j+1,n):
                sumNumber = numbers[i] + numbers[j] + numbers[z]
                sumNumbers.append(sumNumber)

    sumNumbers = list(set(sumNumbers))
    sumNumbers.sort(reverse=True)

    print(f"#{test_case} {sumNumbers[4]}")