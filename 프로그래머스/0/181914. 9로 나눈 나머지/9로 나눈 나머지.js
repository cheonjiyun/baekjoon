function solution(number) {
    return [...number].reduce((acc, el) => acc + +el, 0)%9;
}