function solution(numbers) {
    var answer = 0;
    numbers.forEach(el =>
        answer += el
    )
    return answer / numbers.length;
}