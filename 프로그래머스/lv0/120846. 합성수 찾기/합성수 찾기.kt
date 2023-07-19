class Solution {
    fun solution(n: Int): Int {
        
        var answer: Int = 0
        
        for(i in 1..n){
            var divisorCount: Int = 0
            for(j in 1..n){
                if(i % j == 0) divisorCount++ //약수
            }
            if(divisorCount >= 3) answer++ //합성수
            
        }
        return answer
    }
}