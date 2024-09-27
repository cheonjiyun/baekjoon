const INF = 100000 * 200 + 3


function enqueue(arr, data){
    arr.push(data)
    
    let i = arr.length - 1
    
    while(i > 0 && arr[i].fare < arr[Math.floor((i-1)/2)].fare){
        // swap
        const parent = arr[Math.floor((i-1)/2)]
        arr[Math.floor((i-1)/2)] = arr[i]
        arr[i] = parent
        
        i = Math.floor((i-1)/2)
    }    
}

function dequeue(arr){
    const result = arr[0]
    
    const n = arr.length - 1
    arr[0] = arr[n]
    arr.pop()
    
    let i = 0
    
    while((i*2 +1 < n && arr[i].fare > arr[i*2  +1].fare) || i*2 + 2 < n && (arr[i].fare > arr[i*2 + 2].fare)){
        let childIndex = i*2 +1
        if(arr[i].fare > arr[i*2 +2].fare){
            childIndex = i*2 +2
        }
        
        // swap
        const child = arr[childIndex]
        arr[childIndex] = arr[i]
        arr[i] = child
        
        i = childIndex
    }    
    
    return result
}


class Node{
    constructor(id, fare){
        this.id = id;
        this.fare = fare;
    }
}


function dijkstra(connectionArr, minOneArr, row){
    const n = minOneArr.length
    const q = [new Node(row, 0)]
    
    let start = row
    
    while(q.length){        
        // console.log(q)
        const current = q.shift()
        
        if(current.fare > minOneArr[current.id]){
            continue;
        }
        
        for(let i = 1; i < n+1; i++){
            // console.log("connectionArr[current.id][i]::", connectionArr[current.id][i])
            const cost = minOneArr[current.id] + connectionArr[current.id][i] // 지금까지 거리 + i까지 거리
            if(cost < minOneArr[i]){            
                minOneArr[i] = cost
                enqueue(q, new Node(i, cost))    
            }
        }
    }   
}

function checkDFS(connectionArr, minArr, s, ns, a, b, n, visited){    
    let sumMin = minArr[s][ns] + minArr[ns][a] + minArr[ns][b]
    
    visited[ns] = true
    for(let i = 1; i < n + 1; i++){
        if(connectionArr[ns][i] != INF && connectionArr[ns][i] != 0){
            if(!visited[i]){
                const returnMin = checkDFS(connectionArr, minArr, s, i, a, b, n, visited)    
                if(returnMin < sumMin){
                    sumMin = returnMin
                }
            }
            
        }
    }
    
    
    return sumMin
}


function solution(n, s, a, b, fares) {
    
    const connectionArr = Array.from({length: n+1} , () => Array.from({length : n+1}, () => INF)) 
    const minArr = Array.from({length: n+1} , () => Array.from({length : n+1}, () => INF)) 
    for(let i = 0; i < n+1; i++){
        connectionArr[i][i] = 0
        minArr[i][i] = 0
    }
    
    fares.forEach(fare => {
        connectionArr[fare[0]][fare[1]] = fare[2]
        connectionArr[fare[1]][fare[0]] = fare[2]
    })
    
    // 각 지점 별 다익스트라.
    for(let i = 1; i < n+1; i++){        
        dijkstra(connectionArr, minArr[i], i)
    }
    
    const visited = Array.from({length : n+1}, () => false)
    const answer = checkDFS(connectionArr, minArr, s, s, a, b, n, visited)
    
    
    return answer;
}