class Solution {
    fun solution(numbers: IntArray): Double {
        var total: Double = 0.0
        for(i in numbers){
            total += i
        }

        var answer: Double =  total / numbers.size
        return answer
    }
}