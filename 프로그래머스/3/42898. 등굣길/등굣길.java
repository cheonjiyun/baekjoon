class Solution {
    int m;
    int n;
    int[][] arr;
    
    int div = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        this.m = m;
        this.n = n;
        
        arr = new int[n][m];
        arr[0][0]=1;
        
        for(int[] puddle :puddles){
            int c = puddle[0] - 1;
            int r = puddle[1] - 1;
            
            arr[r][c] = -1;
        }
        
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(arr[r][c] == -1){
                    continue;
                }
                
                int top = getValue(r-1,c);
                int left = getValue(r,c-1);
            
                
                arr[r][c] += ((top % div) + (left % div)) % div;
            }
        }
//          for(int r = 0; r < n; r++){
//             for(int c = 0; c < m; c++){
//                 System.out.print(arr[r][c] +" ");
//             }
//             System.out.println();
//         }
        
        return arr[n-1][m-1];
    }
    
    public int getValue(int r, int c){
        
        if(r < 0 || c < 0 || r >= n || c >= m){
            return 0;
        }
        if(arr[r][c] == -1){
            return 0;
        }
        return arr[r][c];
    }
}