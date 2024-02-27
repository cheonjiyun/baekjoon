function solution(a, d, included) {
    let ad = a
    let result = 0
    included.forEach(el => {
        if(el) result += ad
        ad += d
    })
    return result;
}