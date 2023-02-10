import sys

t = int(sys.stdin.readline())

#총 몇번반족
for one_t in range(t):
    #문자열 몇번반복
    s = list(map(str, sys.stdin.readline().split()))

    list_s = list(s[1])
    for one_s in list_s:
        #첫번째 숫자만큼 곱해서 출력한다.
        print(one_s * int(s[0]), end="")
    print("")
