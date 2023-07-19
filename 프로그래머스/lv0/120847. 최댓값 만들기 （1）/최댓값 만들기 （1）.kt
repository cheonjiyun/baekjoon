class Solution {
    fun solution(numbers: IntArray): Int {
        numbers.sort()    
        
        var answer: Int = numbers[numbers.size-1] * numbers[numbers.size-2]
        return answer
    }
}