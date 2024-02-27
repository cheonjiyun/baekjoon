function solution(score) { 
    let answer = []
    
    let sum = score.map((el) => (el[0]+el[1])/2);
    let sumOrder = score.map((el) => (el[0]+el[1])/2).sort((a,b) => b-a)
    
    sum.forEach(el => {
        answer.push(sumOrder.indexOf(el)+1)
    })
    
    return answer;
}