import java.util.*;

class Solution {
    
    int n;
    int k;
    int[][] dungeons;
    int result;
    
    public int solution(int k, int[][] dungeons) {
        this.n = dungeons.length;
        this.k = k;
        this.dungeons = dungeons;
        
        this.result = 0;
        
        permu(0, new int[n], new boolean[n]);
       
        return result;
    }
    
    public void permu(int depth, int[] orders, boolean[] visited){
        if(depth >= n){
            // System.out.println(Arrays.toString(orders));
            // System.out.println(Arrays.toString(visited));
            int count = explore(orders);
            result = Math.max(result, count);
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            orders[depth] = i;
            
            permu(depth+1, orders, visited);
            
            visited[i] = false;
        }
    }
    
    public int explore(int[] orders){
        int tired = k;
        int count = 0;
        for(int i = 0; i < n; i++){
            int order = orders[i];
            
            int min = dungeons[order][0];
            int require = dungeons[order][1];
            
            // System.out.println("데: " +order + " " + min + " " + require);
            if(min <= tired){
                tired -= require;
                count++;
            }
            // System.out.print(tired + " ");
        }
            System.out.println();
        return count;
    }
}