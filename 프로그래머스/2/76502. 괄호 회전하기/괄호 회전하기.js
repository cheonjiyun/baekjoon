function solution(s) {
    var answer = 0;
    
    const n = s.length
    for(let i = 0; i < n; i++){
        const rotate = s.slice(i, n) + s.slice(0, i)
        
        const stack = []
        
        let correct = true;
        for(let j = 0; j < rotate.length; j++){
            const parenthesis = rotate[j]
            if(parenthesis === '[' || parenthesis === '{' || parenthesis === '('){
                stack.push(parenthesis)
            }else{
                const point = stack[stack.length - 1];
                
                if((point === '[' && parenthesis === ']') || (point === '(' && parenthesis === ')') || (point === '{' && parenthesis === '}')){
                    stack.pop();
                }else{
                    correct = false;
                }
            }
            
        }
        
        if(stack.length === 0 && correct){
            answer += 1
        }
            
    }
    return answer;
}