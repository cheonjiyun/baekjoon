function solution(my_string) {
    return Array.from(new Set(Array.from(my_string))).join('');
}