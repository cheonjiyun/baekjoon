import sys

def time_count(letter):
    if letter == 'A' or letter == 'B' or letter == 'C':
        return 3
    elif letter == 'D' or letter == 'E' or letter == 'F':
        return 4
    elif letter == 'G' or letter == 'H' or letter == 'I':
        return 5
    elif letter == 'J' or letter == 'K' or letter == 'L':
        return 6
    elif letter == 'M' or letter == 'N' or letter == 'O':
        return 7
    elif letter == 'P' or letter == 'Q' or letter == 'R' or letter == 'S':
        return 8
    elif letter == 'T' or letter == 'U' or letter == 'V':
        return 9
    elif letter == 'W' or letter == 'X' or letter == 'Y' or letter == 'Z':
        return 10
    else:
        return 0


#할머니 문자 받기
grandmother_letter = list(sys.stdin.readline().strip())

#총걸리는 시간
sums = 0
for each_grandmother_letter in grandmother_letter:
    sums += time_count(each_grandmother_letter)

#출력
print(sums)