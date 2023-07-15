class Solution {
    fun solution(n: Int, k: Int): Int {  
        print(n / 6)
        var answer: Int = 12000 * n + 2000 * k - (n / 10) * 2000
        return answer
    }
}