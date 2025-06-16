function solution(arr) {
    var answer = 0;
    
    const count = Array(101).fill(0);
    
    arr.forEach(el => {
        
        let number = el;
        // 소인수분해
        const factor = {};
        while(number > 1){            
            for(let i = 2; i <= number; i++){
                if(number % i == 0){
                    number /= i;
                    
                    factor[i] = factor[i] ? factor[i] + 1 : 1;
                    break;
                }
            }
        }
        
        // 최댓값이면 교체
        for(const [key, value] of Object.entries(factor)){
            if(count[key] < value){
                count[key] = value;
            }        
        }      
    })
    
    // 최소공배수
    let result = 1;
    for(let i = 1; i <= 100; i++){
        if(count[i] >= 1){
            result *= i ** count[i];            
        }
    }
    
    return result;
}