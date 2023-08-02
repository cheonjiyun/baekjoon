class Solution {
    fun solution(str1: String, str2: String): Int {        
        var answer: Int = if(str1.contains(str2)) 1 else 2
        return answer
    }
}