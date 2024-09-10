T = int(input())
for test_case in range(1, T+1):
    d, a, b, f = map(int, input().split())

    print(f"#{test_case} {f * d / (a + b)}" )