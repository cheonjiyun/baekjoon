h, m = map(int, input().split())
cook = int(input())

m = m + cook

#분이 60분을 넘을 경우
while(m >= 60):
    #시간 +1
    h = h + 1

    #00시일 경우
    if(h >= 24):
        h = 0

    #분 60빼주기
    m = m - 60


print(h, m)

