function solution(n) {
    let number = [...n.toString(3)].reverse();
    
    let answer = 0
    number.forEach((x, i) => {
        answer += (x) * (3 ** (number.length - 1 - i))
    })
    
    return answer
    
}