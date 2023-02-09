import sys

C = int(sys.stdin.readline()) #반복횟수

for i in range(C):
    students = list(map(int, sys.stdin.readline().split())) #학생수 학생점수리스트...

    students_mean = (sum(students)-students[0])/ students[0] #학생점수 평균
    count = 0
    for iii in students[1:]:
        if iii > students_mean: #평균넘는 학생수
            count += 1

    percent = round((count / students[0]) * 100, 3)  # 퍼센트


    print("{:.3f}%".format(percent))



