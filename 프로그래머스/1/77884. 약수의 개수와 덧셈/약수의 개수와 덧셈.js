function solution(left, right) {
    
    let answer = 0
    //약수 구하기
    for(let number = left; number <= right; number++){        
        let primeCount = 0
        for(let i = 1; i <= number; i++){
            if(number % i == 0) primeCount++
        }
        primeCount % 2 ? answer -= number : answer += number
    }
    return answer;
}