class Solution {
    fun solution(n: Int): IntArray {
        var answer: IntArray = intArrayOf()
        
        for(i in 1..n){
            if(n % i == 0) { answer += i }
        }
        
        return answer
    }
}