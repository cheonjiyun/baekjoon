
import java.io.BufferedReader; // BufferedReader import
import java.io.BufferedWriter; // BufferedWriter import
import java.io.InputStreamReader; // InputStreamReader import
import java.io.OutputStreamWriter; // OutputStreamWriter import
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



class Edge {
  int s;
  int e;
  int t;

  public Edge(int s, int e, int t) {
    this.s = s;
    this.e = e;
    this.t = t;
  }
}


public class Main {

  public static int INF = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    // ------ 입력 ------
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int tc = Integer.valueOf(br.readLine());
    for (int test_case = 0; test_case < tc; test_case++) {
      String[] first = br.readLine().split(" ");
      int n = Integer.valueOf(first[0]);
      int m = Integer.valueOf(first[1]);
      int w = Integer.valueOf(first[2]);

      List<Edge> edges = new ArrayList<>();

      for (int i = 0; i < m; i++) {
        String[] line = br.readLine().split(" ");
        int s = Integer.valueOf(line[0]);
        int e = Integer.valueOf(line[1]);
        int t = Integer.valueOf(line[2]);

        edges.add(new Edge(s, e, t));
        edges.add(new Edge(e, s, t));
      }

      for (int i = 0; i < w; i++) {
        String[] line = br.readLine().split(" ");
        int s = Integer.valueOf(line[0]);
        int e = Integer.valueOf(line[1]);
        int t = Integer.valueOf(line[2]);

        edges.add(new Edge(s, e, -t));
      }

      // -------- 입력 끝 --------

      // ------ 벨반포드 시작 ------
      boolean flag = false;
      for (int i = 1; i <= n; i++) {
        boolean result = bellmanford(i, n, edges);
        if (result) {
          flag = true;
          break;
        }
      }

      System.out.println(flag ? "YES" : "NO");

      // Iterator<Edge> resultNumbers = edges.iterator();
      // while (resultNumbers.hasNext()) {
      // Edge e = resultNumbers.next();
      // bw.write(String.valueOf(e.s + " " + e.e + " " + e.t + "\n"));
      // }
    }


    br.close();
    // 최종 출력
    bw.flush();
    bw.close();
  }

  public static boolean bellmanford(int start, int n, List<Edge> edges) {

    int[] dist = new int[n + 1]; // 출발점부터 n까지 걸리는 시간
    Arrays.fill(dist, INF);
    dist[start] = 0;


    for (int i = 0; i < n - 1; i++) {
      boolean isUpdate = false;
      for (Edge edge : edges) {
        int s = edge.s;
        int e = edge.e;
        int t = edge.t;

        // System.out.println("-- 아래는 dist ---");
        // for (int z = 1; z < n + 1; z++) {
        // System.out.print(dist[z] + " ");
        // }
        // System.out.println();

        // Integer.MAX_VALUE에 더하면 오버플로우 생김
        // 도달하지 못하면 검사 안함
        if (dist[s] != INF && dist[e] > dist[s] + t) { // 더 작은 값을 발견
          dist[e] = dist[s] + t;
          isUpdate = true;
        }
      }
      if (!isUpdate) {
        break;
      }
    }

    for (Edge edge : edges) {
      int s = edge.s;
      int e = edge.e;
      int t = edge.t;

      if (dist[s] != INF && dist[e] > dist[s] + t) { // 계속 무한대로 최솟값이 나온다? 음수 사이클이 있다.
        return true;
      }
    }

    return false;
  }
}
