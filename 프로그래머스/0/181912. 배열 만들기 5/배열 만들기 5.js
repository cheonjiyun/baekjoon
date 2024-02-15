function solution(intStrs, k, s, l) {
    var answer = [];
    
    intStrs.forEach(intNum => {
        const sliceNum = intNum.slice(s, s+l) // 짜르기
        if(sliceNum > k) answer.push(+sliceNum) // 크기검사 + 정수변환
    })
    return answer;
}