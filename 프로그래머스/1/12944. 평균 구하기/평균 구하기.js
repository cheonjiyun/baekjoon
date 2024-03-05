function solution(arr) {    
    return arr.reduce((acc, el) => acc + el, 0) / arr.length;
}