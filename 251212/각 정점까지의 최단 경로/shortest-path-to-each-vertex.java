import java.util.*;

public class Main {

    static ArrayList<Edge>[] adjList;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt() - 1;

        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();

            adjList[u].add(new Edge(v, w));
            adjList[v].add(new Edge(u, w));
        }

        dijkstra(k);
    }

    static final int MAX = 20_000 * 10;

    static void dijkstra(int startIdx){
        Queue<Element> pq = new PriorityQueue<>();
        pq.offer(new Element(startIdx, 0));

        int[] distances = new int[n];
        for(int i = 0; i < n; i++){
            distances[i] = MAX;
        }
        distances[startIdx] = 0;

        while(!pq.isEmpty()){
            Element cur = pq.poll();

            if(cur.distFromStart != distances[cur.idx]){
                continue;
            }

            for(Edge edge : adjList[cur.idx]){
                int newDist = cur.distFromStart + edge.weight;

                if(distances[edge.dest] > newDist){
                    distances[edge.dest] = newDist;
                    pq.offer(new Element(edge.dest, newDist));
                }

            }

        }

        for(int i = 0; i < n; i++){
            if(distances[i] == MAX){
                System.out.println(-1);
            }else{
                System.out.println(distances[i]);
            }
            
        }
    }

    static class Element implements Comparable<Element>{
        int idx;
        int distFromStart;

        public Element(int idx, int distFromStart){
            this.idx = idx;
            this.distFromStart = distFromStart;
        }

        @Override
        public int compareTo(Element other){
            return this.distFromStart - other.distFromStart;
        }
    }

    static class Edge{
        int dest;
        int weight;

        public Edge(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
    }
}