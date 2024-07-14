T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, K = map(int, input().split(' '))
    scores = list(map(int, input().split(' ')))

    # 높은 순으로
    scores.sort(reverse=True)
    # k번째까지
    answer = sum(scores[:K])

    print(f"#{test_case} {answer}")
