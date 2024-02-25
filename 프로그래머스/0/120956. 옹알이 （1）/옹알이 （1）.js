function solution(babbling) {    
    return babbling.map(el => el.replaceAll(/aya|ye|woo|ma/g, 'x')).map(el => el.replaceAll('x', '')).filter(el => el == '').length
}