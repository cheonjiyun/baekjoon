function solution(numbers) {
    var answer = Array.from({length : 10}, (v, i) => i)
    return answer.filter((el) => !numbers.includes(el)).reduce((acc, el) => acc + el, 0);
}