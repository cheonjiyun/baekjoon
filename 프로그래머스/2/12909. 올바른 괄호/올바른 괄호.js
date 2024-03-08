function solution(s){

    let open = [];
    let close = [];
    
    for(let i = 0; i< s.length; i++){
        if(s[i] == '('){
            open.push('(')
        }else{
            if(!open.pop()) return false
        } 
    }
    
    return !open.length
}