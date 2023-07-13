class Solution {
    fun solution(money: Int): IntArray {
        val coffee: Int = 5500
        var cups: Int = -1
        var change: Int = -1
        for(cup in 1..10000000){
            if(coffee * cup > money){ //돈이 안되는 순간
                cups = cup-1
                change = money - (cup-1) * coffee
                break
            }
        }
        var answer: IntArray = intArrayOf(cups, change)
        return answer
    }
}