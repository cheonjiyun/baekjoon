function solution(s) {
    let answer = []
    for(let i = 0 ; i < s.length; i++){
        const whereSame = s.slice(0, i).lastIndexOf(s[i])
        if (whereSame == -1){
            answer.push(-1);
        }else{
            answer.push(i - whereSame)
        }
    }
    return answer
}