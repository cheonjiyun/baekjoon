function solution(s){
    
    let pCount = 0;
    let yCount = 0;
    [...s.toLowerCase()].forEach((el) => {
        if(el == 'p') pCount++
        else if(el == 'y') yCount++
    })
    return pCount === yCount
}