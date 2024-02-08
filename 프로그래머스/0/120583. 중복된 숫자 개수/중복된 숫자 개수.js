function solution(array, n) {
    let answer = array.filter((element) => element == n);
    return answer.length;
}