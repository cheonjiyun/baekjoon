function solution(i, j, k) {
    let count = 0
    
    for(let num = i; num <= j; num++){
        count += [...`${num}`].filter(el => el == k).length;
    }
    
    return count
}