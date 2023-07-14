class Solution {
    fun solution(my_string: String, n: Int): String {
        var answer: String = ""
        
        for(string in my_string){
            for(count in 1..n)
                answer += string
        }

        return answer
    }
}