class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 1
        
        var factorSum: Int = 1 //팩토리얼이 들어갈 배열
                
        for(i in 1..n+1){
            factorSum *= i //계산
                                   
            if(factorSum > n) { //초과시
                answer = i-1
                break;
            }
        }
        
        return answer
    }
}