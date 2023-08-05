class Solution {
    fun solution(my_string: String): Int {
        var answer: Int = 0
        var myStringArray = my_string.split("[a-zA-Z]".toRegex())
        for(i in myStringArray){
            if(i != "") answer += i.toString().toInt()
        }
        return answer
    }
}