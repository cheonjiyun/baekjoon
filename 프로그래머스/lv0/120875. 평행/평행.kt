import kotlin.math.*

class Solution {
    fun solution(dots: Array<IntArray>): Int {
        var answer: Int = 0
        
        val one_two = (dots[0][1] - dots[1][1]) / (dots[0][0] - dots[1][0].toDouble())
        val three_four = (dots[2][1] - dots[3][1]) / (dots[2][0] - dots[3][0].toDouble())
        
        val one_three = (dots[0][1] - dots[2][1]) / (dots[0][0] - dots[2][0].toDouble())
        val two_four = (dots[1][1] - dots[3][1]) / (dots[1][0] - dots[3][0].toDouble())
        
        val one_four = (dots[0][1] - dots[3][1]) / (dots[0][0] - dots[3][0].toDouble())
        val two_three = (dots[2][1] - dots[2][1]) / (dots[1][0] - dots[2][0].toDouble())
        
        if(one_two == three_four || one_three == two_four || one_four == two_three){
            answer = 1
        }
        if(one_two == three_four && one_three == two_four && one_four == two_three){
            answer = 0
        }
        return answer
    }
}