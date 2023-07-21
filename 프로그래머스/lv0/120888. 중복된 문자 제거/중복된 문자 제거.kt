class Solution {
    fun solution(my_string: String): String {
        var answer: String = ""
        
        for(i in my_string){
            if(!answer.contains(i)) answer += i
        }
        return answer
    }
}