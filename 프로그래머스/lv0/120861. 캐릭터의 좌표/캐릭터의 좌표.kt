class Solution {
    fun solution(keyinput: Array<String>, board: IntArray): IntArray {
        var answer: IntArray = intArrayOf(0, 0)
        var realBoard: IntArray = intArrayOf(board[0] / 2, board[1] / 2)
    
        for(i in keyinput){
            if(i == "left" && -realBoard[0] < answer[0] ){
                answer[0] -= 1
            }else if(i == "right" && realBoard[0] > answer[0]){
                answer[0] += 1
            }else if(i == "up" && realBoard[1] > answer[1]){
                answer[1] += 1
            }else if(i == "down" && -realBoard[1] < answer[1]){
                answer[1] -= 1
            }
        }
        
        return answer
    }
}