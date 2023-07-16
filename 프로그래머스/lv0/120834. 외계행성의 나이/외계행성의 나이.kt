class Solution {
    fun solution(age: Int): String {
        
        var answer: String = ""
        
        for(i in age.toString()) answer += ((i.toInt()+49).toChar())            

        return answer
    }
}