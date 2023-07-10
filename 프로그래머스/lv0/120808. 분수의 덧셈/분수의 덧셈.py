def solution(numer1, denom1, numer2, denom2):
    
    # 분수계산법으로 계산
    numer = denom1 * numer2 + denom2 * numer1
    denom = denom1 * denom2
    
    #작은 값 까지만
    if numer > denom:
        big = denom
    else:
        big = numer
        
    # 최대공약수로 나누기
    for i in range(big,1,-1):
        if numer%i == 0 and denom%i == 0:
            numer /= i
            denom /= i
        
    answer = [ numer, denom ]
    return answer