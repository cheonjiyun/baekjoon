class Solution {
    fun solution(sides: IntArray): Int {
        
        sides.sort()         
        var answer: Int = if(sides[2] < sides[0] + sides[1]) 1 else 2
        return answer
    }
}