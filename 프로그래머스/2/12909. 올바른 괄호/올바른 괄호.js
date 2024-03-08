function solution(s){
    let openStack = [];
    
    for(let i = 0; i< s.length; i++){
        if(s[i] == '('){
            openStack.push('(')
        }else{
            if(!openStack.pop()) return false
        } 
    }
    
    return !openStack.length
}