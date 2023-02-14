import sys

fixedCost, variableCost, price = map(int, sys.stdin.readline().strip().split())

# 손익 분기점 : (price - variableCost) * count - fixedCost > 0
if variableCost >= price: # 비용이 더 들거나 같으면 영원히 손익 분기점을 넘지 못한다.
    print(-1)
else:
    print(int(fixedCost / (price - variableCost))+1)