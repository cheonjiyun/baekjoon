class Solution {
    fun solution(n: Int): IntArray {
        var answer: IntArray = intArrayOf()
        var remainN: Int = n
        var isN: Int = 0
        
        while(remainN != 1){
            for(i in 2..remainN){
                if(remainN % i == 0){
                    remainN = remainN / i
                    answer += i
                    
                    
                    break
                }
                
            }
        }
        
            

        
        answer = answer.distinct().toIntArray()
        
        return answer
    }
}