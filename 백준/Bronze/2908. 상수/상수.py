import sys

# 뒤집는 함수
def reverse_def(number: list):
    number = list(map(str, str(number).strip())) #리스트로 바꾸어서 뒤집기
    number = number[::-1]
    return int("".join(number))

number_a, number_b = map(int, sys.stdin.readline().split())

result_number = max(reverse_def(number_a), reverse_def(number_b)) #둘중 큰값
print(result_number)