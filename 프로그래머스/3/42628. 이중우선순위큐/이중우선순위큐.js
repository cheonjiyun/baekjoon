
// 최소힙으로 삽입
function insert(q, number){
    q.push(number)
    
    let i = q.length - 1
    
    while(i > 0){        
        const parentIndex =  Math.floor((i - 1) / 2)
        
        if(q[parentIndex] < q[i]) break // 부모가 더 작으면 stop
        
        // swap
        const parent = q[parentIndex]
        q[parentIndex] = q[i]
        q[i] = parent
        
        i = parentIndex
    }    
}

//최소값 삭제
function deleteMin(q){
    if(q.length == 0) return
    const result = q[0]
    
    q[0] = q.at(-1)
    q.pop()
    
    let i = 0
    
    while(i < q.length && q[i] != undefined){
        const childLeft = i*2 + 1
        const childRight = i*2 + 2
        
        let minIndex = i
        if(q[minIndex] > q[childLeft]){
            minIndex = childLeft
        }
        if(q[minIndex] > q[childRight]){
            minIndex = childRight            
        }
        
        if(minIndex == i) break //부모가 더 작으면 멈춤
        
        // swap
        const child = q[minIndex]        
        q[minIndex] = q[i]
        q[i] = child
        
        i = minIndex
    }
    
    return result
}


//최댓값 삭제
function deleteMax(q){
    //최댓값 index
    const maxNumber = Math.max(...q)
    let maxIndex = q.findIndex((el) => el == maxNumber)
    if(maxIndex == -1) return
    
    //최댓값을 맨 오른쪽으로    
    const lastIndex = q.length - 1
    // swap
    const maxN = q[maxIndex]
    q[maxIndex] = q[lastIndex]
    q[lastIndex] = maxN
        
    //맨오른쪽 삭제
    return q.pop()
}

function solution(operations) {    
    const q = []    
    
    operations.forEach(operation => {
        const [command, number] = operation.split(' ')
        if(command == 'I'){
            insert(q, Number(number))
        }else if(command == 'D' && number == -1){
            deleteMin(q)
        }else if(command == 'D' && number == 1){
            deleteMax(q)
        }
    })
    
    const answer = [0,0]
    if(q.length){
        answer[0] = Math.max(...q)
        answer[1] = q[0]
    }
    
    console.log(q)
    return answer
}