number = list(map(int, input().split()))

store = [0, 0, 0, 0, 0, 0]

#주사위 번호 개수 저장
for i in number:
    if i == 1:
        store[0] += 1
    elif i == 2:
        store[1] += 1
    elif i == 3:
        store[2] += 1
    elif i == 4:
        store[3] += 1
    elif i == 5:
        store[4] += 1
    else:
        store[5] += 1


if max(store) == 3:
    result = 10000 + (store.index(max(store)) + 1) * 1000 #최대값의 해당 숫자
elif max(store) == 2:
    result = 1000 + (store.index(max(store)) + 1) * 100
else:
    result = 100 * max(number) #number의 최대값

print(result)
