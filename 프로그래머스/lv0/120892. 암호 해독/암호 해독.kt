class Solution {
    fun solution(cipher: String, code: Int): String {
        var answer: String = ""
        
        for(i in 1..cipher.length){
            if(i % code == 0)
                answer += cipher[i-1].toString()
        }
        
        return answer
    }
}