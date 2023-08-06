class Solution {
    fun solution(n: Int): Int {
        var answer: Int = n
        
        
        for(i in 1..answer){
            if(i.toString().contains('3')) answer += 1
            else if(i % 3 == 0) answer += 1
        }
        return answer
    }
}