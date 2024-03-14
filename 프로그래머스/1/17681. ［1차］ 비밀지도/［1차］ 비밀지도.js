function solution(n, arr1, arr2) {
    let binary1 = arr1.map((el) => "0".repeat(n - el.toString(2).length) + el.toString(2))
    let binary2 = arr2.map((el) => "0".repeat(n - el.toString(2).length) + el.toString(2))
    let answer = []
    for(let i = 0; i < n; i++){
        let wall = ""
        for(let j = 0 ; j < n; j++){
            wall += binary2[i][j] | binary1[i][j] ? "#" : " "            
        }
        answer.push(wall)
    }    
    return answer
}