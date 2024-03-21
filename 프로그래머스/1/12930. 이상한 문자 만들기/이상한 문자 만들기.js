function solution(s) {   
    return s.split(' ').map((el) => [...el].map((str, i) => i % 2 ? str.toLowerCase() : str.toUpperCase()).join('')).join(' ')
}