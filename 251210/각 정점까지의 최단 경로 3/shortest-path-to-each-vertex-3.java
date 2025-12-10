import java.util.*;

public class Main {

    static ArrayList<Edge>[] adjList;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        adjList = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() -1;
            int v = sc.nextInt() -1;
            int w = sc.nextInt();

            adjList[u].add(new Edge(v, w));
        }

        dijstra(0);
        // Please write your code here.
    }

    static void dijstra(int startIdx){
        Queue<Element> pq = new PriorityQueue<Element>();
        int[] dists = new int[n];
        for(int i = 0; i < n; i++){
            dists[i] = max_val;
        }

        dists[startIdx] = 0;
        pq.offer(new Element(startIdx, dists[startIdx]));

        while(!pq.isEmpty()){
            Element cur = pq.poll();

            if(cur.dist != dists[cur.idx]){
                continue;
            }

            for(Edge edge : adjList[cur.idx]){
                
                int newDist = cur.dist + edge.weight;
                if(dists[edge.destIdx] > newDist){
                    dists[edge.destIdx] = newDist;
                    pq.offer(new Element(edge.destIdx, newDist));
                }
            }
        }
        
        for(int i = 1; i < n; i++){
            System.out.println(dists[i] == max_val ? -1 : dists[i]);
        }

    }
    static int max_val = 100 *1000 * 10;

    static class Edge{
        int destIdx;
        int weight;

        public Edge(int destIdx, int weight){
            this.destIdx = destIdx;
            this.weight = weight;
        }
    }

    static class Element implements Comparable<Element>{
        int idx;
        int dist;

        public Element(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }   

        @Override
        public int compareTo(Element other){
            return this.dist - other.dist;
        }
    }   
}