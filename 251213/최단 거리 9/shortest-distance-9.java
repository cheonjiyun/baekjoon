import java.util.*;
public class Main {

    static ArrayList<Edge>[] adjList;
    static int n;
    static final int MAX_VAL = 1_000 * 100_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        adjList = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();

            adjList[u].add(new Edge(v, w));
            adjList[v].add(new Edge(u, w));
        }
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;

        dijkstra(a, b);
    }

    static void dijkstra(int startIdx, int endIdx){
        Queue<Element> pq = new PriorityQueue<Element>();
        pq.offer(new Element(startIdx, 0));

        int[] distances = new int[n];
        for(int i = 0; i < n; i++){
            distances[i] = MAX_VAL;
        }
        distances[startIdx] = 0;

        int[] lastPath = new int[n]; // 최소값 저장할 때 직전 idx;
        for(int i = 0; i < n; i++){
            lastPath[i] = -1;
        }

        while(!pq.isEmpty()){
            Element cur = pq.poll();

            if(cur.destFrmStart != distances[cur.idx]){
                continue;
            }

            for(Edge edge : adjList[cur.idx]){
                
                int newDist = cur.destFrmStart + edge.weight;
                if(distances[edge.dest] > newDist){
                    distances[edge.dest] = newDist;
                    lastPath[edge.dest] = cur.idx;
                    pq.offer(new Element(edge.dest, newDist));
                }
            }
        }

        System.out.println(distances[endIdx]);

        ArrayList<Integer> pathes = new ArrayList<>();
        int current = endIdx;
        while(current != startIdx){
            pathes.add(current);
            current = lastPath[current];
        }
        pathes.add(current);

        for(int i = pathes.size() - 1; i >= 0; i--){
            System.out.print(pathes.get(i)+1 + " ");
        }
    }

    static class Element implements Comparable<Element>{
        int idx;
        int destFrmStart;

        public Element(int idx, int destFrmStart){
            this.idx = idx;
            this.destFrmStart = destFrmStart;
        }

        @Override
        public int compareTo(Element other){
            return this.destFrmStart - other.destFrmStart;
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