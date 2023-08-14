import kotlin.math.*

class Solution {
    fun solution(numlist: IntArray, n: Int): IntArray {
        var answer: IntArray = intArrayOf()
        var dinArray = IntArray(numlist.size) {10001}
        
        var minimumValue = 10001
        var minimumIndex = -1
        
        for(i in 0 until numlist.size){ 
            dinArray[i] = abs(n - numlist[i])
        }
        
        while(answer.size != numlist.size){
            for(i in 0 until dinArray.size){
                if(minimumValue > dinArray[i]){
                    minimumValue = dinArray[i]
                    minimumIndex = i
                    
                }else if(minimumValue == dinArray[i]){                  
                    if(numlist[minimumIndex] < numlist[i]) {//큰값
                        minimumValue = dinArray[i]
                        minimumIndex = i
                    }   
                }
            }
            
            
            minimumValue = 10001 //초기화
            answer += numlist[minimumIndex] //추가
                
            
            dinArray[minimumIndex] = 10001 //삭제    
            
        }       
    
        
        return answer
    }
}