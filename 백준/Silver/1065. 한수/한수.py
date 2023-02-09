import sys

#함수
def h(n):
    count = 0 #한수 개수
    for number in range(1, n+1): #1보다 크거나 같고 N보다 작거나 같은
        number_list = list(map(int, str(number)))
        correct = 1 #0이 되면 등차수열이 아닌 것

        if len(number_list) == 3: #3자리수 이상이면
            if number_list[2] - number_list[1] != number_list[1] - number_list[0]: #각 자리수의 차이가 다르면
                correct = 0

        if len(number_list) == 4:
            if not(number_list[3] - number_list[2] == number_list[2] - number_list[1] == number_list[1] - number_list[0]):
                correct = 0

        if(correct == 1): #등차수열이면
            count += 1
    return count

#입력 & 출력
x = int(sys.stdin.readline())
print(h(x))
