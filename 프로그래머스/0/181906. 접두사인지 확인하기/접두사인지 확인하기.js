function solution(my_string, is_prefix) {
    var answer = 1;
    [...is_prefix].forEach((s, i) => {
        if(my_string[i] != s) answer = 0
    })
    return answer;
}