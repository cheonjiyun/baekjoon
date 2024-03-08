function solution(x) {   
    return !(x % [...`${x}`].reduce((arr,el) => arr + +el, 0))
}