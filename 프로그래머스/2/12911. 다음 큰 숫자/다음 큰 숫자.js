//비트연산보고 시도해본
function solution(n) {   
    
    let find1count;
    let find0count;
    
    for(find1count = 0; !(n & 1); find1count++){
        n = n >> 1;   
    }
    
    for(find0count = 0; n & 1; find0count++){
        n = n >> 1;
    }
    
    n++;
    n = n << 1;

    for(find1count; find1count > 0; find1count--){
        n = n << 1;
    }
    for(find0count--; find0count > 0; find0count--){
        n = n << 1;
        n++
    }
    
    return n
}