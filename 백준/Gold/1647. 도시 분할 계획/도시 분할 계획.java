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
    int m = Integer.parseInt(st.nextToken());

    edgeList = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine().trim());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      edgeList.add(new Edge(a, b, c));
    }
    // 0. 정렬
    Collections.sort(edgeList);

    // 1. 각자 집합
    parents = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      parents[i] = i;
    }

    // 2. 일단 MST만들기
    int MST = 0;
    int linkCount = 0;
    int lastMax = 0;
    for (Edge edge : edgeList) {

      if (union(edge.from, edge.to)) {
        MST += edge.cost;
        linkCount++;
        lastMax = edge.cost;
        if (linkCount == n) {
          break;
        }
      }
    }

    sb.append(MST - lastMax); // 마지막에 가장 큰 길을 뺌
    System.out.println(sb);
  }

  static boolean union(int a, int b) {
    int aRoot = getRoot(a);
    int bRoot = getRoot(b);

    if (aRoot == bRoot) {
      return false;
    }

    parents[aRoot] = bRoot; // 대표자끼리 합치기
    return true;
  }

  static int getRoot(int a) {
    if (a == parents[a]) {
      return a;
    }

    return parents[a] = getRoot(parents[a]);
  }

  static class Edge implements Comparable<Edge> {
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
      super();
      this.from = from;
      this.to = to;
      this.cost = cost;
    }

    @Override
    public String toString() {
      return "Edge [from=" + from + ", to=" + to + ", cost=" + cost + "]";
    }

    @Override
    public int compareTo(Edge o) {
      // TODO Auto-generated method stub
      return this.cost - o.cost;
    }
  }

}