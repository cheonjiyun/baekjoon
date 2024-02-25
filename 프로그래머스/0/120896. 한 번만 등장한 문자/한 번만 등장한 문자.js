function solution(s) {
    return [...s].filter((e, i) => s.indexOf(e) == s.lastIndexOf(e)).sort().join('');
}