import sys

student = []
for i in range(30):
    student.append(i + 1)

for i in range(28):
    number = int(sys.stdin.readline())
    student.remove(number)

for i in student:
    print(i)