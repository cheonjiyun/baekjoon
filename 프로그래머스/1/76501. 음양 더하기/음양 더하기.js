function solution(absolutes, signs) {   
    return absolutes.reduce((acc, el, i) => signs[i] ? acc += el : acc -= el, 0)
}