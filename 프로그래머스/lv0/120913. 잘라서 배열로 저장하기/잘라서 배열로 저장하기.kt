class Solution {
    fun solution(my_str: String, n: Int): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        for(i in 0 until my_str.length step(n)){
            if(i+n > my_str.length){
                answer += my_str.substring(i)
            }else{
                answer += my_str.substring(i, i+n)    
            }
        }
        return answer
    }
}