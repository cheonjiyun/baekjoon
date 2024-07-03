T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    arr = map(int, input().split())

    count = {}
    for x in arr:
        if x in count:
            count[x] += 1
        else:
            count[x] = 1

    for key, value in count.items():
        if value != 2:
            print(f"#{test_case} {key}")
