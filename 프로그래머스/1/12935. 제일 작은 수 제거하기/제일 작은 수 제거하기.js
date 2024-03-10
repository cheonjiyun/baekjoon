function solution(arr) {
    var answer = arr.filter(el => el != Math.min(...arr))    
    if(!answer.length) answer = [-1]
    return answer;
}