function solution(s) {
    const sSplit = s.split(' ')
    return `${Math.min(...sSplit)} ${Math.max(...sSplit)}`
}