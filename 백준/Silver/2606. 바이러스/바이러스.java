import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int result = -1;
  private static ArrayList<ArrayList<Integer>> list;
  private static int n;
  private static int m;

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    n = Integer.parseInt(st.nextToken());

    list = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i <= n; i++) {
      list.add(new ArrayList<>());
    }
    st = new StringTokenizer(br.readLine().trim());
    m = Integer.parseInt(st.nextToken());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine().trim());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list.get(a).add(b);
      list.get(b).add(a);
    }

    bfs();
    sb.append(result);

    System.out.println(sb);
  }

  static void bfs() {
    Queue<Integer> q = new ArrayDeque<Integer>();
    q.offer(1);

    boolean[] visited = new boolean[n + 1];
    visited[1] = true;
    while (!q.isEmpty()) {
      int cur = q.poll();
      result++;

      for (int next : list.get(cur)) {
        if (visited[next])
          continue;
        visited[next] = true;
        q.add(next);
      }
    }
  }

}