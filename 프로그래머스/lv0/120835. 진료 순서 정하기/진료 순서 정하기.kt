class Solution {
    fun solution(emergency: IntArray): IntArray {
        var emergencySort: IntArray = emergency.sortedArrayDescending()
        var answer = IntArray(emergency.size)
        
        var i = 0
        for(patient in emergency){
            answer[i] = emergencySort.indexOf(patient)+1
            i++
        }
        return answer
    }
}