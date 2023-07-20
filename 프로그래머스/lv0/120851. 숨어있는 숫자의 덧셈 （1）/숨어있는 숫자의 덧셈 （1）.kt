class Solution {
    fun solution(my_string: String): Int {
        var answer: Int = 0
        
        for(i in my_string){
            if(i.toInt() >= 48 && i.toInt() <= 57) answer += i.toString().toInt()
        }
        
        return answer
    }
}