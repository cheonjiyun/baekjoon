class Solution {
    fun solution(polynomial: String): String {
        var polynomialArray = polynomial.split(" + ")
        
        var coefficent:Int = 0 //x계수
        var constantTerm:Int = 0 //상수
        
        for(i in polynomialArray){
            //x계수
            if(i.contains('x')){
                if(i.replace("x", "") == ""){ // 계수가 1
                    coefficent += 1
                }else{ 
                    coefficent += i.replace("x", "").toString().toInt()
                }                
            }
            //상수항
            else{
                constantTerm += i.toString().toInt()
            }
        }
        
        var answer: String = ""
        
        //합치기
        if(coefficent != 0 && constantTerm != 0){
            if(coefficent == 1){
                answer = "x + ${constantTerm}"
            }else{
                answer = "${coefficent}x + ${constantTerm}"
            }            
        }else if(coefficent != 0 && constantTerm == 0){
            if(coefficent == 1){
                answer = "x"
            }else{
                answer = "${coefficent}x"
            }
            
        }else if(coefficent == 0 && constantTerm != 0){
            answer = "${constantTerm}"
        }
        
        return answer
    }
}