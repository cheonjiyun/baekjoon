class Solution {
    fun solution(n: Int): Int {
        var answer: Int = n
        
        
        for(i in 1..answer){
            if(i % 3 == 0 || i.toString().contains('3')) answer += 1            
        }
        return answer
    }
}