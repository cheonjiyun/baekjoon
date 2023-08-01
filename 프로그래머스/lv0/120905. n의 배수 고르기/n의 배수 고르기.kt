class Solution {
    fun solution(n: Int, numlist: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        
        for(i in numlist){
            if(i % n == 0){
                answer += i
            }
        }
        return answer
    }
}