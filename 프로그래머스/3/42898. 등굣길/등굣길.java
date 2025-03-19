class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        
        int[][] count = new int[n][m];
        count[0][0] = 1;
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(isPuddle(r, c, puddles)) continue;
                
                if(r-1 >= 0){
                    count[r][c] = (count[r][c] + count[r-1][c]) % 1000000007;
                }if(c-1>=0){
                    count[r][c] = (count[r][c] + count[r][c-1]) % 1000000007;
                }
            }
        }
        
        return count[n-1][m-1] % 1000000007;
    }
    
    public boolean isPuddle(int r, int c, int[][] puddles){
        for(int i = 0; i < puddles.length; i++){
            int[] puddle = puddles[i];
            if(puddle[0] -1 == c && puddle[1] -1 == r){
                return true;
            }
        }
        return false;
    }
}