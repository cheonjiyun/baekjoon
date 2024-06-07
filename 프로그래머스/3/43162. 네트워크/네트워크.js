function solution(n, computers) {
    const computerArr = new Array(n).fill(0)
    const q = []
    
    let result = 0
    
    for(let i = 0; i < n; i++){
        if(computerArr[i] == 1) continue; // 이미 방문한 컴퓨터
        
        result++ // 네트워크 개수 추가
        
        q.push(i) // 방문할 컴퓨터 추가
        while(q.length){
            const node = q.shift(); // 방문할 컴퓨터
            computerArr[node] = 1; // 방문확인
            
            for(let c = 0; c < n; c++){ // 연결된 컴퓨터가 있는지 돌면서 확인
                if(computers[node][c] == 1 && computerArr[c] != 1){ // 연결된컴퓨터가 있음 && 방문안한컴퓨터다
                    q.push(c) // 방문할 예정
                }
            }
        }
        
    }
        
    return result;
}