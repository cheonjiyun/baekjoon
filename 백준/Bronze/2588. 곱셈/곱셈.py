a = int(input())
b = list(map(int, input()))

one = a * b[-1]
ten = a * b[-2]
hundred = a * b[-3]

print(one)
print(ten)
print(hundred)
print(one + (ten * 10) + (hundred * 100))