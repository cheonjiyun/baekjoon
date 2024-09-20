function solution(n) {
    var answer = [];
    
    for(let i = 1 ; i <= n ; i++){
        answer.push(Array.from({length : i}, () => 0))
    }
    
    let numberN = 1
    let x = 0
    let y = 0
    let d = 0 
    
    const dx = [0, 1, -1]
    const dy = [1, 0, -1]
    
    const isTurn = [n]
    for(let i = 1; i < n; i++){
        isTurn.push(n - i + isTurn[i-1])
    } 
    console.log(isTurn)
    
    while(numberN <= (n + 1) * (n / 2)){
        // 현재 숫자
        answer[y][x] = numberN
        
        
        // Turn 조건
        if(isTurn.includes(numberN)){
            d = (d + 1) % 3
        }
        
        
        
        // 다음 숫자
        numberN += 1        
        
        // // 다음에 둘곳
        x += dx[d]
        y += dy[d]
    
    } 
    
    const result = []
    answer.forEach((el) => {
        el.forEach(e => {
            result.push(e)
        })        
    })
    return result;
}