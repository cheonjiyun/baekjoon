for x in range(5):
    for y in range(5):
        if x == y:
            print('#', end='')
        else:
            print('+', end='')
    print('')