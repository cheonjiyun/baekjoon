class Solution {
    fun solution(s: String): String {
        var answer: String = ""
        
        for(i in s){
            if(s.count{it == i} == 1) answer += i
        }
        
        
        return String(answer.toCharArray().sortedArray())
    }
}