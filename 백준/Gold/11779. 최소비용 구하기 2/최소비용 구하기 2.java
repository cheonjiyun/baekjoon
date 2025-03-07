
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

      adjList.get(start).add(new Node(end, cost, new ArrayList<>()));
    }

    st = new StringTokenizer(br.readLine().trim());
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());

    Result result = dijksta(start, end);

    sb.append(result.minCost).append("\n").append(result.visitCitys.size()).append("\n");
    for (int city : result.visitCitys) {
      sb.append(city).append(" ");
    }

    System.out.println(sb);
  }

  static Result dijksta(int start, int end) {

    boolean[] visited = new boolean[n + 1];
    int[] dist = new int[n + 1];
    List[] memo = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) {
      memo[i] = new ArrayList<>();
    }

    Arrays.fill(dist, 100000000);
    dist[start] = 0;

    Queue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0, new ArrayList<>(Arrays.asList(start))));
    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (visited[cur.city])
        continue;
      visited[cur.city] = true;

      for (Node adj : adjList.get(cur.city)) {
        if (dist[adj.city] > dist[cur.city] + adj.cost) {
          dist[adj.city] = dist[cur.city] + adj.cost;

          List<Integer> newCity = new ArrayList<>();
          for (int city : cur.visitCitys) {
            newCity.add(city);
          }
          newCity.add(adj.city);
          memo[adj.city] = newCity;

          pq.offer(new Node(adj.city, dist[adj.city], newCity));
        }
      }
    }

    return new Result(dist[end], memo[end]);
  }

  static class Result {
    int minCost;
    List<Integer> visitCitys;

    public Result(int minCost, List<Integer> visiteCitys) {
      super();
      this.minCost = minCost;
      this.visitCitys = visiteCitys;
    }

    @Override
    public String toString() {
      return "Result [minCost=" + minCost + ", visitCitys=" + visitCitys + "]";
    }


  }

  static class Node implements Comparable<Node> {
    int city;
    int cost;
    List<Integer> visitCitys;

    public Node(int city, int cost, List<Integer> visitCitys) {
      super();
      this.city = city;
      this.cost = cost;
      this.visitCitys = visitCitys;
    }

    @Override
    public int compareTo(Node o) {
      return this.cost - o.cost;
    }

    @Override
    public String toString() {
      return "Node [city=" + city + ", cost=" + cost + ", visitCitys=" + visitCitys + "]";
    }


  }
}
