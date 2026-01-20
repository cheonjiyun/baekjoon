import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int n = routes.length;
        
        
        Arrays.sort(routes, (a,b) -> {
            if(a[1] == b[1]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        
        int currentNum = -30_001;
        int count = 0;
        for(int idx = 0; idx < n; idx++){
            int start = routes[idx][0];
            int end = routes[idx][1];
            
            if(start <= currentNum){
                continue;
            }
            currentNum = end;
            count++;
        }
        
        // for(int i = 0 ; i < routes.length; i++){            
        //     System.out.print(Arrays.toString(routes[i]) + " ");
        // }
        return count;
    }
}