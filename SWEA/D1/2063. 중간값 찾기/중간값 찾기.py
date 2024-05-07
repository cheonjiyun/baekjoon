T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.

numbers = list(map(int, input().split()))
numbers.sort()
mid = numbers[int(len(numbers) / 2)]
print(mid)