function solution(priorities, location) {
    var answer = 0;
    
    const maxCount = Array(10).fill(0);
    let maxPriority = 0;
    
    const q = [];
    for(const priority of priorities){
        maxCount[priority] += 1;   
        q.push(priority);
        
        // 최대 우선순위
        if(maxPriority < priority){
            maxPriority = priority;
        }
    }
  
    let resultCount = 0;
    let outCount = 0;
    let index = 0;
    const visited = Array(priorities.length).fill(false);
    while(outCount < priorities.length){
        const cur = q[index];
        
        if(cur != maxPriority){
            index = (index + 1) % priorities.length;
        }else{
            // 실행
            maxCount[cur] -= 1;
            resultCount++;
            outCount++;
            visited[index] = true;

            if(index == location){
                break;
            }

            if(maxCount[cur] == 0){
                for(let i = maxPriority - 1; i >= 1; i--){
                    if(maxCount[i] == 0){
                        continue;
                    }else{
                        maxPriority = i;
                        break;
                    }
                }
            }
        }
        
        while(true){
            if(visited[index]){
                index = (index + 1) % priorities.length;
            }else{
                break;
            }
        }
        
      
    }
    
    return resultCount;
}