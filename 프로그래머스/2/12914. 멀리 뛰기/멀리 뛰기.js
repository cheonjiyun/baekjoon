function solution(n) {    
    
    // 경우에 수만 계산하면 된다
    const countArr = [1, 2]
    for(let i = 2; i < n; i++){
        countArr.push((countArr[i-1] + countArr[i-2]) % 1234567)
    }   
    
    return countArr[n - 1];
}