function solution(left, right) {
    
    let answer = 0
    //약수 구하기
    for(let number = left; number <= right; number++){        
        Number.isInteger(Math.sqrt(number)) ? answer -= number : answer+= number
    }
    return answer;
}