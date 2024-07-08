T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    stringList = list(input())

    for _ in range(len(stringList)):
        print("..#.", end='')
    print(".")

    for _ in range(len(stringList)):
        print('.#.#',end='')
    print(".")

    string = ".#.".join(stringList)
    print(f"#.{string}.#")


    for _ in range(len(stringList)):
        print('.#.#',end='')
    print(".")


    for _ in range(len(stringList)):
        print("..#.", end='')
    print(".")
