
T = int(input())
for test_case in range(1, T + 1):
    n, a, b = map(int, input().split(' '))
    minPersonnel = a + b - n
    if minPersonnel < 0:
        minPersonnel = 0
    print(f"#{test_case} {min(a,b)} {minPersonnel}")
