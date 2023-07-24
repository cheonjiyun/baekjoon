class Solution {
    fun solution(my_string: String): String {
        var answer: String = ""
        for(i in my_string){
            if(i.isUpperCase()){
                answer += i.toLowerCase()
            }else{
                answer += i.toUpperCase()
            }
        }
        return answer
    }
}