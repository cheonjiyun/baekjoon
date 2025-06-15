

function solution(users, emoticons) {
    const answer = [0,0];
    
    for(let salePer = 10; salePer <= 40; salePer += 10){
        dfs(users, emoticons, 0, salePer, Array.from({length : users.length}, () => 0));
    }
    
    
    function dfs(users, emoticons, k, salePer, totalCosts){
        const newTotalCosts = Array.from({length : users.length}, () => 0)
        
        for(let i = 0; i < users.length; i++){
            newTotalCosts[i] += totalCosts[i];
            
            const isBuy = users[i][0] <= salePer;   
         
            if(isBuy){
                newTotalCosts[i] += emoticons[k] - (emoticons[k] * (salePer / 100));
            }
             
        }

        if(k == emoticons.length - 1){
            // console.log(newTotalCosts);
            
            const result = [0,0];            
            
            newTotalCosts.forEach((cost, idx) => {
                if(cost >= users[idx][1]){
                    result[0] += 1;
                }else{
                    result[1] += cost;
                }
            })

            if(answer[0] < result[0] || (answer[0] == result[0] && answer[1] < result[1])){
                answer[0] = result[0];
                answer[1] = result[1];
            }
            return;
        }else{
            for(let salePer = 10; salePer <= 40; salePer += 10){
                dfs(users, emoticons, k + 1, salePer, newTotalCosts);
            }
        }
        
        
    }
    
    return answer;
}


