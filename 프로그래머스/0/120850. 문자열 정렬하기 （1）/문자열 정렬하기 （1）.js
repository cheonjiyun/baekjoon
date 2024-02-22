function solution(my_string) {
    let answer = [...my_string].filter(el => el >= 0 && el <= 9).map(el => +el).sort()
    if (answer.length === 0) {
        answer.push(0)
    }
    return answer
}