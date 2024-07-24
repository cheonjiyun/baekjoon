for test_case in range(1, 11):
    times = int(input())
    boxes = list(map(int, input().split()))
    boxes.sort() # 정렬

    for _ in range(times):
        boxes[len(boxes)-1] -= 1 # 1등 하나 내림
        boxes[0] += 1 # 꼴찌 올림
        boxes.sort()

    print(f"#{test_case} {boxes[len(boxes)-1] -boxes[0]}")
