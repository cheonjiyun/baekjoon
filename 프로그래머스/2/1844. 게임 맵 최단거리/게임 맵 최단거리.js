function solution(maps) {
    var answer = 0;
    
    const q = []
    q.push([0,0, 1])
    maps[0][0] = 0
    
    const n = maps[0].length
    const m = maps.length
    
    const dx = [1, 0, -1, 0]
    const dy = [0, 1, 0, -1]
    
    let goal = false
    let count = 0
    while(q.length){
        const ql = q.length
        
        const [x, y, count] = q.shift()

        if(x == n - 1 && y == m - 1){
            return(count)
        }

        // 4면
        for(let i = 0; i < 4; i++){
            const nx = dx[i] + x
            const ny = dy[i] + y

            if(nx >= 0 && nx < n && ny >= 0 && ny < m && maps[ny][nx] == 1){
                maps[ny][nx] = 0 // 방문
                q.push([nx, ny, count + 1])
            }
        }
        
    }
    return goal ? count : -1;
}