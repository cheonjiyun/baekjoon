function solution(s) {
    if(s.length % 2){
        return s[Math.trunc(s.length / 2)]
    }else{ // 짝수
        return s.slice(s.length / 2 - 1, s.length / 2 + 1)
    }
    
}