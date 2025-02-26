import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int[] parents;
  static int n;

  static List<Edge> edgeList = new ArrayList<>();

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    n = Integer.parseInt(in.readLine());
    parents = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      edgeList.add(new Edge(0, i, Integer.parseInt(in.readLine()))); // 우물 0
    }

    StringTokenizer st;
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 1; j <= n; j++) {
        int value = Integer.parseInt(st.nextToken());
        if (i != j)
          edgeList.add(new Edge(i, j, value));
      }
    }

    makeSet();
    Collections.sort(edgeList);

    int result = 0;
    int count = 0;
    for (Edge edge : edgeList) {
      if (union(edge.from, edge.to)) { // 연결이 안되어 있으면 연결 시켜주고
        result += edge.weight; // 비용 추가
        if (++count == n) { // 우물 포함 모든 노드가 연결 되면 끝
          sb.append(result).append("\n");
        }
      }
    }

    System.out.println(sb);
  }

  static void makeSet() {
    for (int i = 0; i <= n; i++) {
      parents[i] = i;
    }
  }

  static int findSet(int x) {
    if (parents[x] == x)
      return x;
    return parents[x] = findSet(parents[x]);
  }

  static class Edge implements Comparable<Edge> {
    int from, to, weight;

    public Edge(int from, int to, int weight) {
      super();
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      return this.weight - o.weight;
    }

  }

  static boolean union(int a, int b) {
    int aRoot = findSet(a);
    int bRoot = findSet(b);
    if (aRoot == bRoot)
      return false;


    parents[bRoot] = aRoot;
    return true;
  }
}