class Solution {
    public int[] solution(int[] prices) {
        
        int n = prices.length;
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++){
            for(int next = i+1; next < n; next++){
                
                answer[i] += 1;            
                if(prices[i] > prices[next]){      
                    break;
                }
            }
        }
        
        return answer;
    }
}