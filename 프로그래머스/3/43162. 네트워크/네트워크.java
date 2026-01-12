import java.util.*;

class Solution {
    
    int[][] computers;
    boolean[] visited;
    int n;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        
        visited = new boolean[n+1];
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            count++;
            bfs(i);
        }
        
        
        return count;
    }
    
    public void bfs(int startI){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(startI);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int adj = 0; adj < n; adj++){
                if(computers[cur][adj] == 0){
                    continue;
                }
                if(visited[adj]){
                    continue;
                }
                visited[adj] = true;
                q.offer(adj);
            }
        }
    }
}