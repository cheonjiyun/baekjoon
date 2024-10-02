function dfs(numbers, i, number, target){
    if(i == numbers.length){
        if(number == target){
            return 1
        }
        else{
            return 0
        }
    }
    
    let answer = 0
    
    answer += dfs(numbers, i+1, number + numbers[i], target)
    answer += dfs(numbers, i+1, number - numbers[i], target)
    
    return answer
}


function solution(numbers, target) {   
    return dfs(numbers, 0, 0, target);
}