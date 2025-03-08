import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static List<Edge> edgeList;
  static int[] parents;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int n = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());

    edgeList = new ArrayList<>();

    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine().trim());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      edgeList.add(new Edge(a, b, c));
    }

    // 1.작은 순 정렬
    Collections.sort(edgeList);

    // 2. 각자 서로소 집합으로 만들기
    parents = new int[n + 1]; // 본인 부모 (연결된)
    for (int i = 0; i <= n; i++) {
      parents[i] = i; // 본인을 부모로 설정
    }

    // 3. MST
    int mst = 0;
    int linkCount = 0;
    for (Edge edge : edgeList) {
      if (union(edge.start, edge.end)) { // union 성공인가요??
        mst += edge.weight;
        if (linkCount == n - 1) { // 연결 끝
          linkCount++;
          break;

        }
      }
    }

    sb.append(mst);
    System.out.println(sb);
  }

  private static boolean union(int a, int b) {
    int aRoot = findSet(a);
    int bRoot = findSet(b);

    if (aRoot == bRoot) {
      return false;
    }

    parents[aRoot] = bRoot;
    return true;


  }

  private static int findSet(int a) {
    if (parents[a] == a) {
      return a; // 본인이 대표자일때까지
    }

    parents[a] = findSet(parents[a]);
    return parents[a];
  }

  static class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
      super();
      this.start = start;
      this.end = end;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
    }

    @Override
    public int compareTo(Edge o) {
      return this.weight - o.weight;
    }

  }

  static void kruskal() {

  }
}