class Solution {
    fun solution(sides: IntArray): Int {
        var answer: Int = 0
        val longSize: Int = if(sides[0] > sides[1]) sides[0] else sides[1]
        val shortSize: Int = if(sides[0] < sides[1]) sides[0] else sides[1] 
        
        answer += longSize - (longSize - shortSize + 1) + 1 //지금긴변이 긴변
        answer += longSize + shortSize - 1 - longSize //나머지변이 긴변
        
        return answer
    }
}