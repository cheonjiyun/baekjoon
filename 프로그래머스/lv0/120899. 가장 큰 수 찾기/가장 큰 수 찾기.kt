class Solution {
    fun solution(array: IntArray): IntArray {
        val answerMaxValue: Int = array.maxOrNull()!!.toInt()
        val answerMaxIndex: Int = array.indexOf(answerMaxValue)
        var answer: IntArray = intArrayOf(answerMaxValue, answerMaxIndex)
        return answer
    }
}