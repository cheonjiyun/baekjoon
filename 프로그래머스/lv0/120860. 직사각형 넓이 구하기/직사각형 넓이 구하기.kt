import kotlin.math.*

class Solution {
    fun solution(dots: Array<IntArray>): Int {
        //대각선 꼭짓점만 구함
        var x1y1: IntArray = dots[0]
        lateinit var x2y2: IntArray
        for(i in dots){
             if(x1y1[0] != i[0] && x1y1[1] != i[1]){
                 x2y2 = i
             }
        }
        
        var answer: Int = abs(x2y2[0] - x1y1[0]) * abs(x2y2[1] - x1y1[1])
        return answer
    }
}