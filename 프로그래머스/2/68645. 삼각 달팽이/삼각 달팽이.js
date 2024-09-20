function solution(n) {
    var answer = [];
    
    for(let i = 1 ; i <= n ; i++){
        answer.push(Array.from({length : i}, () => 0))
    }
    
    let numberN = 1
    let x = 0
    let y = -1

    for(let i = n; i > 0; i -= 3){
        for(let j = 0; j < i; j++) answer[++y][x] = numberN++;        
        for(let j = 0; j < i-1; j++) answer[y][++x] = numberN++;        
        for(let j = 0; j < i-2; j++) answer[--y][--x] = numberN++;
        
    }
    
    return answer.flat();
}