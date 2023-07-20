class Solution {
    fun solution(my_string: String): String {
        var answer: String = ""
        for(i in my_string){
            if(i != 'a' && i != 'e' && i != 'i' && i != 'o' && i != 'u'){
                answer += i
            }
            
        }
        return answer
    }
}