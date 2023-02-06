import sys

N = int(sys.stdin.readline())

for i in range(N):
    ox = list(map(str, sys.stdin.readline())) #점수 받기

    # 점수계산
    score = 0
    continue_count = 0
    for ox_content in ox:
        if ox_content == "O": #O일때
            continue_count += 1 # O이면 연속카운트
            score += continue_count * 1
        else: # X일때
            continue_count = 0 # x면 초기화

    print(score)
