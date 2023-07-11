class Solution {
    fun solution(array: IntArray): Int {
        
        array.sort()        
        
        var answer: Int = array[array.size / 2]
        return answer
    }
}