import kotlin.math.*

class Solution {
    fun solution(balls: Int, share: Int): Int {
        var answer: Int = (factorial(balls.toDouble()) / (factorial((balls-share).toDouble()) * factorial(share.toDouble()))).roundToInt()
        return answer
    }
    
    fun factorial(n: Double): Double{
        if(n <= 1) return 1.0
        else{
            return n * factorial(n-1)
        }        
    }
}