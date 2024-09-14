
function dfs(n, k, start, dest, tmp){
    if(n < k) return []
    
    const result = []
    
    const abc = [1,2,3]
    
    // n-1 왼
    result.push(...dfs(n, k+1, start, tmp, dest))
    // n
    result.push([start, dest])
    // n-1 오
    result.push(...dfs(n, k+1, tmp, dest, start))
    
//     if(n<=1){
//         return [[start, start+2]]
//     }
    
//     if(n>=2 && n % 2 == 0){
//         result.push([start, start+1])
//         result.push([start, start+2])
//         result.push([start+1, start+2])        
//     }else if(n>=2 && n % 2 == 1){
//         result.push([start, start+2])
//         result.push([start, start+1])
//         result.push([start+2, start+1])            
//     }
   
//     if(n>=3){                
//         result.push([start, start+2])
    
//         result.push([start+2, start])
//         result.push([start+2, start+1])
//         result.push([start, start+1])
//     }

                 
                 
//     result.push([1, 2])
//     result.push([1, 2])
//     result.push([2, 3])
   
//     result.push([1, 2])
    
//     result.push([3, 1])
//     result.push([3, 2])
//     result.push([1, 2])
    
    return result
        
}

function solution(n) {
    var answer = [[]];
    
    return dfs(n, 1, 1, 3, 2);
}