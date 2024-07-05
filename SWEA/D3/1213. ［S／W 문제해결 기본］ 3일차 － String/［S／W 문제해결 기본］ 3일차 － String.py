for _ in range(1, 11):
    test_case = int(input())
    targetString = input()
    strings = input()

    count = 0
    for i in range(0, len(strings) - len(targetString) + 1):
        if targetString == strings[i: i+len(targetString)]:
            count += 1

    print(f"#{test_case} {count}")
