function solution(s) {
    let remove0 = 0;
    let removeRe = 0;
    let strBefore = s;
    let strAfter = '';
    while(strBefore != '1'){
        for(let i = 0; i < strBefore.length; i++){
            if(strBefore[i] == '0'){
                remove0++
            }else{
                strAfter += strBefore[i]
            }
        }
        strBefore = strAfter.length.toString(2)
        strAfter = '' 
        removeRe++
    }
    
    return [removeRe ,remove0]
}