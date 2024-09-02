MAX_NUMBER = 1000001
arr = [True for i in range(MAX_NUMBER)]

for i in range(2, MAX_NUMBER):
    if arr[i]:
        j = 2
        while i * j < MAX_NUMBER:
            arr[i * j] = False
            j += 1

for i in range(2, len(arr)):
    if arr[i]:
        print(i, end=" ")