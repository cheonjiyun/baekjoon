class Solution {
    fun solution(array: IntArray): Int {
        var answer: Int = 0
        for(i in array){
            answer += i.toString().count{ it == '7'}
        }
        return answer
    }
}