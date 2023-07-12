class Solution {
    fun solution(slice: Int, n: Int): Int {
        var answer: Int = 0
        for(pizza in 1.. 100){
            if((slice * pizza) >= n){
                answer = pizza
                break
            }
                
        }

        
        
        return answer
    }
}