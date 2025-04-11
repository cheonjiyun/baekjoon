import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int INF = 1000000000;

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int n = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine().trim());
    int m = Integer.parseInt(st.nextToken());

    int[][] dist = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        dist[i][j] = INF;
        if (i == j) {
          dist[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine().trim());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (dist[a][b] > c) {
        dist[a][b] = c;
      }
    }

    for (int mid = 1; mid <= n; mid++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          dist[i][j] = Math.min(dist[i][j], dist[i][mid] + dist[mid][j]);
        }
      }
    }


    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (dist[i][j] == INF) {
          sb.append(0);
        } else {
          sb.append(dist[i][j]);
        }
        sb.append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}