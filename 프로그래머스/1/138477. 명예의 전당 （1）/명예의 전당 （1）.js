function solution(k, score) {
    let answer =[]
    var theHallOfFame = [];
    

    
    //명예의 전당
    for(let i = 0; i < score.length; i++){
        const rank = theHallOfFame.findIndex(el => el < score[i]);
        
        //3개만 추리기
        rank == -1 ? theHallOfFame.push(score[i]) : theHallOfFame.splice(rank, 0, score[i]);
        theHallOfFame.splice(k, 1);
         
        //발표점수
        answer.push(theHallOfFame[theHallOfFame.length-1])
    }
    return answer;
}