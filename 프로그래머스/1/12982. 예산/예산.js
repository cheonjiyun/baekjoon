function solution(d, budget) {
    var answer = 0;
    
    d.sort((a,b ) => a-b)
    for(let request of d){
        budget -= request
        if(budget >= 0){
            answer++
        }
    }
        

    
    
    return answer;
}