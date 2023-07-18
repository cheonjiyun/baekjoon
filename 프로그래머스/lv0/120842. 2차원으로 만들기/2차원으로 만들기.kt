class Solution {
    fun solution(num_list: IntArray, n: Int): Array<IntArray> {       
        var answer: Array<IntArray> = Array(num_list.size/n, {IntArray(n,{0})}) //2차원
        
        var i = 0
        for(one in 0 until num_list.size/n){
            for(two in 0 until n){
                answer[one][two] = num_list[i]
                i++
            }
            
        }
        
        return answer
    }
}