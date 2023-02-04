h, m = map(int, input().split())

m = m - 45

#시가 바뀌어야 할 때
if m < 0:
    if (h - 1) < 0:
        h = 23
    else:
        h = h - 1
    m = 60 - (-m)

#출력
print(h, m)