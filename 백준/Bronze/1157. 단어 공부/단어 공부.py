import sys
from collections import Counter

word = str(sys.stdin.readline().strip())
word = word.upper()

freq = Counter(word).most_common()
if len(freq) >= 2 and freq[0][1] == freq[1][1]: # 글자가 두개 이상인데 1위 2위 수가 같다면
    print("?")
else: # 나머미는 다 첫번쨰 순위
    print(freq[0][0])

