function solution(A, B) {
    let answer = -1
    for(let i = A.length; i >= 0; i--){
        if((A.slice(A.length - i) + A.slice(0, A.length - i)) == B) answer = i        
    }
    return answer
}