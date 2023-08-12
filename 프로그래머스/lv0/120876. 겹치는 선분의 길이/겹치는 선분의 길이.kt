class Solution {
    fun solution(lines: Array<IntArray>): Int {
        var answer: Int = 0
        
        var overlap = Array(201){0}
            
        for (line in lines){
            for (i in line[0] until line[1]){
                overlap[i+100] += 1
            }
        }
        
        for (i in 0 until overlap.size){
            if(overlap[i] > 1){
                answer += 1
            }
        }       

        return answer
    }
}