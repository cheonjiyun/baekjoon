import java.util.*;

class Solution {
    
    ArrayList<Edge> edges; 
    int[] parents;
    int n;
    
    public void init(){
        parents = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
    }
    
    public int solution(int n, int[][] costs) {
        this.n = n;
        int v = costs.length;
        
        init();
        edges = new ArrayList<>();
        
        boolean[] connected = new boolean[n+1];
        
        for(int[] cost : costs){
            int start = cost[0];
            int end = cost[1];
            int weight = cost[2];
            
            edges.add(new Edge(start,end,weight));
        }
        
        Collections.sort(edges);
        
        int k = 0;
        int answer = 0;
        for(int i = 0; i < v; i++){
            Edge edge = edges.get(i);
            if(!isSameGroup(edge.s, edge.e)){
                union(edge.s, edge.e);
                k++;
                answer += edge.w;
            }
            if(k == n-1){
                break;
            }
            System.out.println(edge);
        }
        
        
        return answer;
    }
    
    int find(int x){
        // 본인
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    
    boolean isSameGroup(int a, int b){
        return find(a) == find(b);
    }
    
    void union(int a, int b){
        int ap = find(a);
        int bp = find(b);
        
        if(ap != bp){
            parents[ap] = bp;
        }
    }
    
    class Edge implements Comparable<Edge>{
        int s;
        int e;
        int w;
        
        public Edge(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
        
        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.w, o.w);
        }
        
        @Override
        public String toString(){
            return "[" + s + " " + e + " " + w + "]";
        }
    }
}