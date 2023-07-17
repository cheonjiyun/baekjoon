class Solution {
    fun solution(hp: Int): Int {
        // hp / 5 //장군개미
        // hp % 5 / 3 // 병정개미
        // hp % 5 % 3 //  
        var answer: Int = hp / 5 + hp % 5 / 3 + hp % 5 % 3
        return answer
    }
}