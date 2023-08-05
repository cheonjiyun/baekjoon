class Solution {
    fun solution(spell: Array<String>, dic: Array<String>): Int {
        var answer: Int = 0
        
        var onlyOne: Boolean = true
        for(dics in dic){
            onlyOne = true
            for(i in spell){
                if(dics.count { it.toString() == i } != 1){ //하나만
                    onlyOne = false
                    break
                }
            }
            if(onlyOne){
                answer = 1
                break
            }
        }
        
        if(!onlyOne){
            answer = 2
        }
        
        
        
        
        return answer
    }
}