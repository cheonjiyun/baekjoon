class Solution {
    fun solution(n: Int): Int {
        
        
        var answer: Int = if(n % 7 == 0 ) n / 7 else n / 7 + 1
        return answer
    }
}