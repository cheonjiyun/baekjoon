SIZE = 3

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    s, k = input().split()
    current = [0 for _ in range(SIZE)]

    for i in range(SIZE):
        if s[i] == "o":
            current[i] = 1

    for i in range(int(k)):
        update = [i for i in current]
        for j in range(SIZE):
            if j == 0 and current[j] != 0:
                update[1] += current[0]
                update[0] = 0
            if j == 1 and current[j] != 0:
                update[0] += 1/2 * current[1]
                update[2] += 1/2 * current[1]
                update[1] = 0
            if j == 2 and current[j] != 0:
                update[1] += current[2]
                update[2] = 0
        current = update

    print(f"#{test_case} {current.index(max(current))}")
