import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int n;
  static List<ArrayList<Node>> adjList;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    n = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine().trim());
    int m = Integer.parseInt(st.nextToken());

    adjList = new ArrayList<ArrayList<Node>>();
    for (int i = 0; i <= n; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine().trim());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      adjList.get(start).add(new Node(end, cost));
    }

    st = new StringTokenizer(br.readLine().trim());
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());

    sb.append(dijstra(start, end));
    System.out.println(sb);
  }

  static int dijstra(int start, int end) {

    Queue<Node> pq = new PriorityQueue<Node>();
    pq.offer(new Node(start, 0));

    boolean[] visited = new boolean[n + 1];

    int[] dist = new int[n + 1];
    Arrays.fill(dist, 1000000000);
    dist[start] = 0;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (visited[cur.end])
        continue;
      visited[cur.end] = true;

      for (Node adjNode : adjList.get(cur.end)) {
        if (!visited[adjNode.end] && dist[adjNode.end] > dist[cur.end] + adjNode.cost) {
          dist[adjNode.end] = dist[cur.end] + adjNode.cost;

          pq.offer(new Node(adjNode.end, dist[adjNode.end]));
        }
      }
    }

    return dist[end];

  }

  static class Node implements Comparable<Node> {
    int end;
    int cost;

    public Node(int end, int cost) {
      super();
      this.end = end;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return this.cost - o.cost;
    }

    @Override
    public String toString() {
      return "Node [end=" + end + ", cost=" + cost + "]";
    }


  }
}