import java.util.*;

class Solution {
    
    Node[] players;
    int n;
    
    public int solution(int n, int[][] results) {
        this.n = n;
        
        players = new Node[n+1];
        for(int i = 0; i < n+1; i++){
            players[i] = new Node(i);
        }
        
        for(int[] result : results){
            int winer = result[0];
            int loser = result[1];
            
            players[winer].children.add(loser);
            players[loser].parents.add(winer);
        }
        
        int count = 0;
        for(int i = 1; i < n + 1; i++){
            if(isAllKnow(i)){
                count++;
            }
        }
    
        return count;
    }
    
    public boolean isAllKnow(int idx){
        int parentCount = getParent(idx, new boolean[n+1]);
        if(parentCount > 0){
            parentCount--;
        }
        int childrenCount = getChildren(idx, new boolean[n+1]);
        if(childrenCount > 0){
            childrenCount--;
        }
        
        return parentCount + childrenCount == n-1;
    }
    
    public int getParent(int idx, boolean[] visited){
        if(visited[idx]){
            return 0;
        }
        visited[idx] = true;
        int sum = 1;
        for(int parent : players[idx].parents){
            sum += getParent(parent, visited);
        }
        return sum;
    }
    
    public int getChildren(int idx, boolean[] visited){
        if(visited[idx]){
            return 0;
        }
        visited[idx] = true;
        int sum = 1;
        for(int child : players[idx].children){
            sum += getChildren(child, visited);
        }
        return sum;
    }
    
    class Node{
        int idx;
        ArrayList<Integer> parents = new ArrayList<>();
        ArrayList<Integer> children = new ArrayList<>();
        
        public Node(int idx){
            this.idx = idx;
        }
        
        @Override
        public String toString(){
            return "[<idx> " + idx + ", parents: " + parents + ", children: " + children + "]";
        }
    }
}