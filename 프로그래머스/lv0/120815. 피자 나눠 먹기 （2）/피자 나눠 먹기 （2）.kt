class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        for(pizza in 1..100){
            var pizzaPiece = pizza*6
            if((pizzaPiece) % n == 0){                
                answer = pizza
                break
            }
                
        }      
        return answer
    }
}