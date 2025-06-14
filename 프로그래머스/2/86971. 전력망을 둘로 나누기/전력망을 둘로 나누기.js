function solution(n, wires) {
    const adjList = {};
    for(const [start, end] of wires){
        if(!adjList[start]) adjList[start] = [];
        if(!adjList[end]) adjList[end] = [];
        adjList[start].push(end);
        adjList[end].push(start);
    }
    
    let result = 100;
    for(const [start, end] of wires){
        
        const visited = new Array(n+1).fill(false);

        visited[start] = true;
        visited[end] = true;
        const countStart = bfs(start, adjList, visited);
        const countEnd = bfs(end, adjList, visited);
        
        result = Math.min(result, Math.abs(countStart - countEnd));
    }

    return result;
}

function bfs(start, adjList, visited){
    const q = [start];
    let idx = 0;    
    
    let count = 0;
    while(q.length > idx){
        const cur = q[idx++];
        count++;
        
        for(const adj of adjList[cur]){            
            if(visited[adj]) continue;
            visited[adj] = true;
            q.push(adj);
        }
    }
    
    return count;
}