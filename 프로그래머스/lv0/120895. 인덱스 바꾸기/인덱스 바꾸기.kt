class Solution {
    fun solution(my_string: String, num1: Int, num2: Int): String {
        var answer: String = ""
        for(i in 0 until my_string.length){
            if(i == num1){
                answer += my_string[num2]
            }else if(i == num2){
                answer += my_string[num1]
            }else{
                answer += my_string[i]    
            }
            
        }
        
        return answer
    }
}