class Solution {
    fun solution(num_list: IntArray): IntArray {
        
        var odd: Int = 0
        var even: Int = 0
        for(num_value in num_list){
            if(num_value % 2 == 0){
                even += 1
            }else{
                odd += 1
            }
        }
        
        var answer: IntArray = intArrayOf(even, odd)
        return answer
    }
}