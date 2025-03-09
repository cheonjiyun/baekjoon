import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static List<Edge> edgeListAsc;
  static List<Edge> edgeListDesc;
  static int[] parents;
  static int n;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());


    edgeListAsc = new ArrayList<>();
    edgeListDesc = new ArrayList<>();

    // 1. 자기자신 집합


    for (int i = 0; i < m + 1; i++) {
      st = new StringTokenizer(br.readLine().trim());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      edgeListAsc.add(new Edge(a, b, c));
      edgeListDesc.add(new Edge(a, b, c));
    }

    // 오르막길 - 내리막길
    Collections.sort(edgeListAsc, new Comparator<Edge>() {
      @Override
      public int compare(Edge o1, Edge o2) {
        return o1.updown - o2.updown;
      }
    });

    // 내리막길 -> 오르막길 순
    Collections.sort(edgeListDesc, new Comparator<Edge>() {
      @Override
      public int compare(Edge o1, Edge o2) {
        return o2.updown - o1.updown;
      }
    });

    makeSet();
    int max = 0;
    int count = 0;
    for (Edge edge : edgeListAsc) {
      if (union(edge.from, edge.to)) { // 합치기 성공하면

        if (edge.updown == 0) {
          max += 1;
        }
        count++;

        if (count == n) {
          break;
        }
      }
    }

    makeSet();
    int min = 0;
    count = 0;
    for (Edge edge : edgeListDesc) {
      if (union(edge.from, edge.to)) { // 합치기 성공하면
        if (edge.updown == 0) {
          min += 1;
        }
        count++;

        if (count == n) {
          break;
        }
      }
    }

    sb.append((int) (Math.pow(max, 2) - Math.pow(min, 2)));
    System.out.println(sb);

  }

  static void makeSet() {
    parents = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      parents[i] = i;
    }
  }

  static boolean union(int a, int b) {
    int aRoot = findSet(a);
    int bRoot = findSet(b);

    if (aRoot == bRoot) { // 이미 같은 집합이야
      return false; // 합치기 실패
    }

    parents[aRoot] = bRoot;
    return true;
  }

  static int findSet(int a) { // 대표자 찾기
    if (parents[a] == a) {
      return a;
    }

    return parents[a] = findSet(parents[a]);
  }

  static class Edge {
    int from;
    int to;
    int updown;

    public Edge(int from, int to, int updown) {
      super();
      this.from = from;
      this.to = to;
      this.updown = updown;
    }

    @Override
    public String toString() {
      return "Edge [from=" + from + ", to=" + to + ", updown=" + updown + "]";
    }

  }
}