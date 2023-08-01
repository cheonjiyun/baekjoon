class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        
        var nArray = n.toString().split("")
        for(i in nArray){
            if(i != ""){
                answer += i.toInt()
            }   
        }
        
        return answer
    }
}