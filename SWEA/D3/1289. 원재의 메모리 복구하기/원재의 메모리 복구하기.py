T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # 앞 0제거한 후 문자열 변환
    memory = str(int(input()))
    current = '0'
    count = 0
    
    # 이전값이랑 다르면 count + 1
    for n in memory:
        if n != current:
            current = n
            count += 1

    print(f'#{test_case} {count}')