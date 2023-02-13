import sys

loop = int(sys.stdin.readline())


count = 0 # group_work가 총 몇개 인지
for i in range(loop):
    word = sys.stdin.readline().strip()

    group_work = True  # group_work인지
    min_value = 0 # 이전 index값

    for each_word in word:

        if min_value > word.index(each_word):
            group_work = False
            break
            
            # 현재 index값을 min_value로 바꾼다.
            # 인덱스 값이 같거나 점점 커져야 반복되지 않는 것이다.
            # 현재 index 값이 앞 글자의 index 값보다 작다는 것은 앞에 이미 나왔다는 뜻.
            # 하나라도 아니면 False

        min_value = word.index(each_word)

    if group_work == True:
        count += 1

print(count)