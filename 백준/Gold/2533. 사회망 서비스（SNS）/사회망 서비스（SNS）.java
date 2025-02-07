import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

  //
  static boolean[] visited;
  static int[][] minEarlyNotEarly;
  static List<Integer>[] tree;
  static int n;

  public static void main(String[] args) throws Exception {

    // 입력

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    tree = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i = 0; i < n - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      int u = Integer.valueOf(st.nextToken()) - 1;
      int v = Integer.valueOf(st.nextToken()) - 1;
      tree[u].add(v);
      tree[v].add(u);
    }

    // ----입력 끝----

    visited = new boolean[n];
    minEarlyNotEarly = new int[n][2];

    minEarly(0);

    System.out.println(Math.min(minEarlyNotEarly[0][0], minEarlyNotEarly[0][1]));

  }

  public static void minEarly(int start) {

    visited[start] = true;
    minEarlyNotEarly[start][0] = 1;

    for (int end : tree[start]) { // 한줄

      if (!visited[end]) { //
        minEarly(end);
        minEarlyNotEarly[start][1] += minEarlyNotEarly[end][0];
        minEarlyNotEarly[start][0] += Math.min(minEarlyNotEarly[end][1], minEarlyNotEarly[end][0]);

      }
    }
  }
}
