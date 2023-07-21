class Solution {
    fun solution(strlist: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        
        for(i in strlist){
            answer += i.length
        }
        return answer
    }
}