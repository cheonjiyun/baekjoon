function solution(price, money, count) {
    let answer = ((price + price * count) / 2 * count) - money
    return answer > 0 ? answer : 0
}