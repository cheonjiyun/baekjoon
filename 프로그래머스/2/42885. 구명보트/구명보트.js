function solution(people, limit) {
    people.sort((a,b) => b - a)
    
    let count = 0
    
    let left = 0
    let right = people.length - 1
     
    while(left <= right){        
        if(left < right && people[left] + people[right] <= limit){
            right--
        }
        
        left++
        count++
    }
    
    return count;
}