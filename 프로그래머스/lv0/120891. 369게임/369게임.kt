class Solution {
    fun solution(order: Int): Int {
        var answer: Int = 0
        
        for(i in order.toString()){
            if(i == '3' || i == '6' || i == '9') answer += 1
        }
        return answer
    }
}