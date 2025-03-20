class Solution {
        
    public static int[] solution(int[] sequence, int k) {
        int[] answer = {-1, -1};
    
        // 투포인터
        int left = 0;
        int right = 0;
        int size = sequence.length;
        int sum = 0; // 부분합을 반복해서 계산X - 하나로 하고 줄이는 방식으로
        
        // key: 효율성
        // 투포인터
        // 부분합 변수 하나로
        
        for(int r = 0; r < sequence.length; r++){
            // 부분합에 추가
            sum += sequence[right];
            
            // 크면 같거나 작아질때까지 left++
            while(sum > k && left <= right){ // left가 더 커지지는 않게 방지
                sum -= sequence[left]; // 부분합에서 제외
                left++;
            }
            
            if(sum == k){              
                
                // 같다 -> 조건에 맞으면 업데이트
                if(size > right - left){  // 길이 기록              
                    size = right - left;
                    answer[0] = left;
                    answer[1] = right;
                    
                    // index작은순으로 하고 있기때문에 검사할 필요X
                }
            }
            
            right++;  
            
        }
        
        return answer;
    }
}