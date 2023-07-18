class Solution {
    fun solution(numbers: IntArray, k: Int): Int {
        
        var answer: Int = numbers[(k*2 - 1 - 1) % numbers.size]
        return answer
    }
}