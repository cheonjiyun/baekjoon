import sys

letter = sys.stdin.readline().strip()

sums = 0 # 크로아티아 알파벳 개수

for word in ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']:
    sums += letter.count(word) #개수 더함
    letter = letter.replace(word, ' ') #더한 단어는 공백으로 채움

letter = letter.replace(' ', '') # 공백을 다시 제거
print(len(letter) + sums) # 크로아티아 알파벳 개수 + 영어 앞파벳 개수