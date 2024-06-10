function solution(rectangle, characterX, characterY, itemX, itemY) {
    var answer = 0;
    
    const grid = Array.from({length: 50 * 2 + 1}, () => Array.from({length : 50 * 2 + 1}, () => 0))
    
    rectangle.forEach((el) => {
        let [x1, y1, x2, y2] = el
        
        x1 *= 2
        x2 *= 2
        y1 *= 2
        y2 *= 2
        
        
        for(let y = y1; y <= y2; y++){
            for(let x = x1; x <= x2; x++){
                if(x === x1 || x === x2 || y === y1 || y === y2){ // 굵은 선선
                    if(grid[y][x] !== 2){ // 이미 차잇는 곳은 패쓰
                        grid[y][x] = 1
                    }                    
                }else{
                    grid[y][x] = 2
                }
                
            }
        }        
    })
    
    q = []
    q.push([characterX * 2, characterY * 2, 0])
    
    const dx = [1, 0, -1, 0]
    const dy = [0, 1, 0, -1]
    
    while(q.length){
        const [x, y, count] = q.shift()
        if(x === itemX * 2 && y === itemY * 2){
            return count / 2
        }
        
        for(let i = 0; i < 4; i++){
            const nx = x + dx[i]
            const ny = y + dy[i]
            
            if(nx >= 0 && nx <= 50 * 2 && ny >= 0 && ny <= 50 * 2 && grid[ny][nx] === 1){
                grid[ny][nx] = -1
                q.push([nx, ny, count + 1])
            }
        }
    }
    
    
    return answer;
}