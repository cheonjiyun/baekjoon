function solution(n, computers) {
    const computerArr = new Array(n).fill(0)
    const q = []
    
    let result = 0
    
    for(let i = 0; i < n; i++){
        if(computerArr[i] == 1) continue; // 이미 방문한 컴퓨터
        
        q.push(i)
        while(q.length){
            const node = q.shift();
            computerArr[node] = 1; // 방문확인
            
            for(let c = 0; c < n; c++){
                if(computers[node][c] == 1 && computerArr[c] != 1){ // 연결된컴퓨터 && 방문안한컴퓨터
                    q.push(c)
                }
            }
        }
        result++
    }
        
    return result;
}