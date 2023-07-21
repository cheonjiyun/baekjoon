class Solution {
    fun solution(s: String): Int {
        var sArray = s.split(" ")
        
        var answer: Int = 0
        
        for(i in 0 until sArray.size){
            if(sArray[i] == "Z"){
                answer -= sArray[i-1].toInt()
            }else{
                answer += sArray[i].toInt()
            }           
            
        }
        
        return answer
    }
}