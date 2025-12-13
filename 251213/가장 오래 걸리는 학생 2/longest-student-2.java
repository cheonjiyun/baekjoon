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
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int d = sc.nextInt();
            
            adjList[b].add(new Edge(a, d));
        }

        System.out.println(dijkstra(n-1));
    }

    static int dijkstra(int startIdx){
        Queue<Element> pq = new PriorityQueue<>();
        pq.offer(new Element(startIdx, 0));

        int[] distances = new int[n];
        for(int i = 0; i < n; i++){
            distances[i] = MAX_VAL;
        }
        distances[startIdx] = 0;

        while(!pq.isEmpty()){
            Element cur = pq.poll();

            if(distances[cur.idx] != cur.destFromStart){
                continue;
            }

            for(Edge edge : adjList[cur.idx]){
                
                int newDist = cur.destFromStart + edge.time;

                if(distances[edge.dest] > newDist){
                    distances[edge.dest] = newDist;
                    pq.offer(new Element(edge.dest, newDist));
                }
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            result = Math.max(result, distances[i]);
        }
        return result;
    }


    static final int MAX_VAL = 100_000 * 1_000;

    static class Element implements Comparable<Element>{
        int idx;
        int destFromStart;

        public Element(int idx, int destFromStart){
            this.idx = idx;
            this.destFromStart = destFromStart;
        }

        @Override
        public int compareTo(Element other){
            return this.destFromStart - other.destFromStart;
        }
    }

    static class Edge{
        int dest;
        int time;

        public Edge(int dest, int time){
            this.dest = dest;
            this.time = time;
        }
    }
}