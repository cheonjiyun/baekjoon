class Solution {
    fun solution(array: IntArray): Int {
        var answer: Int = 0
        
        array.sort()

        var maxFrequency = -1
        var maxFrequencyNumber = -1
        var currentNumber = -1
        var currentFrequency = -1
        
        for(i in array){
            if(i != currentNumber){ // 새로운 숫자
                currentNumber = i
                currentFrequency = 0
            }                 
            
            
            currentFrequency += 1
            
            if(maxFrequency < currentFrequency){ // 최빈값
                maxFrequency = currentFrequency
                maxFrequencyNumber = currentNumber
                answer = maxFrequencyNumber
                
            }
            
            // 최빈값 여러개가 같을 때   
            else if(maxFrequencyNumber != currentNumber && maxFrequency == currentFrequency) 
                answer = -1
        }
        

        return answer
    }
}