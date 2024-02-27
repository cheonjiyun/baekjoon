function solution(answers) {
    const mathGiveup1 = [1,2,3,4,5]
    const mathGiveup2 = [2,1,2,3,2,4,2,5]
    const mathGiveup3 = [3,3,1,1,2,2,4,4,5,5]
    
    let correct = [0,0,0]
    
    answers.forEach((el, i) => {
        if(el == mathGiveup1[i % mathGiveup1.length]) correct[0] += 1;
        if(el == mathGiveup2[i % mathGiveup2.length]) correct[1] += 1;
        if(el == mathGiveup3[i % mathGiveup3.length]) correct[2] += 1;
    })
    
    let answer = []
    let max = Math.max(...correct)
    
    correct.forEach((el, i) => {
        if (el == max) answer.push(i+1)
    })
    
    return answer
}