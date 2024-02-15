function solution(l, r) {
    var answer = [];
    
    for(let i = l; i <= r; i++){
        const numArr = [1, 2, 3, 4, 6, 7, 8, 9]; // 5, 0 뺀 숫자
        
        // 5와 0이 아닌 숫자가 들어가 있다면 false가 될 것
        let flag = true 
        numArr.forEach(num => {
            if(`${i}`.includes(num)) flag = false
        })
        
        // 검사 후에도 여전히 flag가 true라면 배열에 넣기
        if(flag) answer.push(i)        
    }
    
    // 빈배열이면 -1 넣어주기
    return answer.length === 0 ? [-1] : answer;
}