class Solution {
    fun solution(letter: String): String {        
        var answer: String = ""
        
        val morse: Array<String> = arrayOf(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
        
        for(i in letter.split(' ')){
            answer += (morse.indexOf(i.toString())+97).toChar()
        }        

        return answer
    }
}