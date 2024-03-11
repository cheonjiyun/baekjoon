function solution(n) {
    if(n == 0) return 0
    if(n == 1) return 1
    
    let fiboArr = [0, 1]
    for(let i = 2; i <= n; i++){
        fiboArr.push((fiboArr[i-2] + fiboArr[i-1]) % 1234567)
    }
    return fiboArr[fiboArr.length - 1]
}