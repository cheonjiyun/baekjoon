#합 함수 만들기
def d(n):
    n_list = list(map(int, str(n)))
    return n + sum(n_list)

#미리 1~10000 저장
list_generator = list(range(1, 10001))

#합이 있는 경우 리스트에서 삭제
i = 1
while i < 10001:
    try:
        list_generator.remove(d(i))
    except:
        pass

    i += 1

#출력
print(*list_generator, sep='\n')