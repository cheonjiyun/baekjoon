class Solution {
    fun solution(quiz: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        
        for(i in quiz){
            var each = i.split(" ")
            var result: Int = 0
            
            if(each[1] == "+"){
                result = each[0].toInt() + each[2].toInt()
            }else if(each[1] == "-"){
                result = each[0].toInt() - each[2].toInt()
            }
            
            if(result == each[4].toInt()){
                answer += "O"
            }else{
                answer += "X"
            }
            
        }
        return answer
    }
}