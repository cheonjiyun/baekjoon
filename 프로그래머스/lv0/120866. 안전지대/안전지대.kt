class Solution {
    fun solution(board: Array<IntArray>): Int {
        
        var answerBoard: Array<IntArray> = Array(board.size, {IntArray(board[0].size, {0})})
        for(row in 0 until board.size){
            for(col in 0 until board[row].size){
                answerBoard[row][col] = board[row][col]
            }
        }
        for(row in 0 until board.size){
            for(col in 0 until board[row].size){
                if(board[row][col] == 1){
                    try{ answerBoard[row-1][col-1] = 1 } catch(e: ArrayIndexOutOfBoundsException){}
                    
                    try{ answerBoard[row-1][col] = 1} catch(e: ArrayIndexOutOfBoundsException){}
                    try{ answerBoard[row-1][col+1] = 1} catch(e: ArrayIndexOutOfBoundsException){}
                    try{ answerBoard[row][col-1] = 1} catch(e: ArrayIndexOutOfBoundsException){}
                    try{ answerBoard[row][col+1] = 1} catch(e: ArrayIndexOutOfBoundsException){}
                    try{ answerBoard[row][col] = 1} catch(e: ArrayIndexOutOfBoundsException){}
                    try{ answerBoard[row+1][col-1] = 1} catch(e: ArrayIndexOutOfBoundsException){}
                    try{ answerBoard[row+1][col] = 1} catch(e: ArrayIndexOutOfBoundsException){}
                    try{ answerBoard[row+1][col+1] = 1} catch(e: ArrayIndexOutOfBoundsException){}
                }
            }
        }
        
        var answer: Int = 0
        for(row in answerBoard){
            for(col in row){
                if(col == 0){
                    answer += 1
                }
                print(col)
            }
        }
        
        return answer
    }
}