class Solution {
    fun solution(numbers: IntArray, direction: String): IntArray {
        var answer: IntArray = IntArray(numbers.size){0}
        
        for(i in 0 until numbers.size){
            if(direction == "right"){
                if(i >= numbers.size-1){
                    answer[0] = numbers[numbers.size-1]
                }else{
                    answer[i+1] = numbers[i]
                }
               
            }else{
                if(i == 0){
                    answer[numbers.size-1] = numbers[0]
                }else{
                    answer[i-1] = numbers[i]
                }
                
            }
        }
        return answer
    }
}