function solution(array) {
    let answer = 0;
    for(let i  = 0; i < array.length; i++){
        answer += Array.from('' + array[i]).filter(e => e == 7).length
    }
    return answer;
}