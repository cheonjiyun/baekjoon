class Solution {
    fun solution(numbers: IntArray, num1: Int, num2: Int): IntArray {
        var answer: IntArray = numbers.copyOfRange(num1, num2+1)
        return answer
    }
}