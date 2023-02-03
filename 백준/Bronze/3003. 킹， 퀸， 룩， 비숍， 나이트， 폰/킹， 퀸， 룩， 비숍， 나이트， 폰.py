chess = list(map(int, input().split()))

number = [1, 1, 2, 2, 2, 8]

result = []

for value, user in zip(number, chess):
    minus = value - user

    result.append(minus)

print(*result)
