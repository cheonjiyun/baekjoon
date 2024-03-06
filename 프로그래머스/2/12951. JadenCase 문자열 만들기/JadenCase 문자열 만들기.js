function solution(s) {
    return s.split(' ').map(el => el.charAt(0)?.toUpperCase() + el.slice(1).toLowerCase()).join(' ')
}