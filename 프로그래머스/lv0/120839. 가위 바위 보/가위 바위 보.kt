class Solution {
    fun solution(rsp: String): String {
        var answer: String = ""
        
        val rock: Char = '0'
        val scissors: Char = '2'
        val paper: Char = '5'             
        
        for(i in rsp){
            if(i == rock) answer += paper            
            else if(i == scissors) answer += rock           
            else answer += scissors            
        }
        
        return answer
    }
}