function quadTree(arr, n, x, y){
    const result = [0, 0]
    
    let sumNumber = 0;
    for(let i = x; i < x + n; i++){
        for(let j = y; j < y + n; j++){
            sumNumber += arr[i][j]
        }
    }
    
    if(sumNumber == n * n){
        result[1] += 1
        return result
    }else if(sumNumber == 0){
        result[0] += 1
        return result
    }
    
    const topLeft = quadTree(arr, n / 2, x, y)
    result[0] += topLeft[0]
    result[1] += topLeft[1]
    const topRight = quadTree(arr, n / 2, x, y + n / 2)
    result[0] += topRight[0]
    result[1] += topRight[1]
    const bottomLeft = quadTree(arr, n / 2, x + n / 2, y)
    result[0] += bottomLeft[0]
    result[1] += bottomLeft[1]
    const bottomRight = quadTree(arr, n / 2, x + n / 2, y + n / 2)
    result[0] += bottomRight[0]
    result[1] += bottomRight[1]
    
    return result
    
}

function solution(arr) {    
    let n = arr.length
    var answer = quadTree(arr, n, 0, 0)
    
    return answer;
}