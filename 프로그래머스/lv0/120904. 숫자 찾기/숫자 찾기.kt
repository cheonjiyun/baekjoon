class Solution {
    fun solution(num: Int, k: Int): Int {
        var numArray = num.toString().split("")
        
        var answer: Int = numArray.indexOf(k.toString())
        return answer
    }
}