class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer: Int = 1
        
        var c = a.toBigDecimal()
        var d = b.toBigDecimal()
        
        try{
            c.divide(d)
        }catch(e : ArithmeticException){
            answer = 2          
        }
        
        return answer
    }
}