function solution(k, tangerine) {
    
    // 객체만들기
    const box = {}
    tangerine.forEach((el) => {
        if(el in box){
            box[el] += 1
        }else{
            box[el] = 1   
        }       
    })
    
    // 많은 순
    const sortTanerine = Object.entries(box).sort((a, b) => b[1] - a[1])
    
    // 한 종류씩 담기
    let result = 0 // 귤 종류
    let count = 0 // 귤 개수
    
    while(count < k){
        count += sortTanerine[result][1]
        result++
    }    
    
    return result;
}