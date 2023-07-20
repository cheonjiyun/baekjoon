class Solution {
    fun solution(my_string: String): IntArray {
        var answer: IntArray = intArrayOf()
        
        for(i in my_string){
            if(i.toInt() >= 48 && i.toInt() <= 57) answer += i.toString().toInt()
        }

        answer.sort()
        
        return answer
    }
}