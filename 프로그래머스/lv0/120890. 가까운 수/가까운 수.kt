class Solution {
    fun solution(array: IntArray, n: Int): Int {       
        array.sort()
        var answer: Int = 0
        var close: Int = 100001
        
        for(i in array){
            if(close > (n - i) * (n - i)){
                close = (n - i) * (n - i)
                answer = i
            }
        }

        return answer
    }
}