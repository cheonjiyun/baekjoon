function solution(a, b) {
    return a.reduce((acc, el, i) =>  acc += el*b[i] , 0);
}