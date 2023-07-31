class Solution {
    fun solution(my_string: String): Int {
        var stringArray = my_string.split(' ')
        var answer: Int = 0
        
        for(i in 0 until stringArray.size){
            if(i == 0) {answer += stringArray[i].toInt()}
            else{
                if(stringArray[i] == "+"){
                    answer += stringArray[i+1].toInt()
                }else if(stringArray[i] == "-"){
                    answer -= stringArray[i+1].toInt()
                }
            }        
        }
        return answer
    }
}