class Solution {
    fun solution(my_string: String, letter: String): String {
        var answer: String = ""
        for(i in my_string){
            if(i.toString() != letter) answer += i
        }

        return answer
    }
}