function solution(elements) {
    
    const n = elements.length
    
    // j번째부터 시작해서 i개를 더한 수를 배열로 저장한다(피보나치dp처럼)
    const arr = Array.from({length: n} , () => Array.from({length: n}, () => 0))
                            
    for(let i = 0; i < n; i++){
        arr[0][i] = elements[i]
    }
    for(let i = 1; i < n; i++){
        for(let j = 0; j < n; j++){
            arr[i][j] = arr[i-1][j] + elements[(j + i) % n]
        }        
    }
    
    const numberSet = new Set()
    for(let i = 0; i < n; i++){
        for(let j = 0; j < n; j++){
            numberSet.add(arr[i][j])
        }
    }
    
    const number = Array.from(numberSet)
    number.sort((a, b) => a - b)
    return number.length;
}