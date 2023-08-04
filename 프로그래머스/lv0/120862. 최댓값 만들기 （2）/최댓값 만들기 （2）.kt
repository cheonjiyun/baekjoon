class Solution {
    fun solution(numbers: IntArray): Int {
        var numbers = numbers
        numbers.sort()
        var answer: Int = if( numbers[0] * numbers[1] > numbers[numbers.size-1] * numbers[numbers.size - 2]) numbers[0] * numbers[1] else numbers[numbers.size-1] * numbers[numbers.size - 2]
        return answer
    }
}