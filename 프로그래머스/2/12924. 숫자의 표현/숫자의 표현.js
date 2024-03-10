function solution(n) {   
    let count = 0;
    
    let start = 1;
    let end = 1;
    while(end <= n){
        let sum = (start + end) / 2 * (end - start + 1)
        if(sum == n){
            count++
            end++;
        }else if(sum < n){
            end++;
        }else{
            start++
        }
    }
    
    return count
}