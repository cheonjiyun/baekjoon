import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] arr = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine().trim());
      for (int j = 1; j <= n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][][] dp = new int[n + 1][n + 1][3]; // 꽉채운거, 본인 기준으로 y줄만, x줄만
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {

        dp[i][j][0] = dp[i - 1][j - 1][0] + dp[i - 1][j][1] + dp[i][j - 1][2] + arr[i][j];
        dp[i][j][1] = dp[i - 1][j][1] + arr[i][j];
        dp[i][j][2] = dp[i][j - 1][2] + arr[i][j];



      }
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine().trim());

      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      sb.append(dp[x2][y2][0] - dp[x1 - 1][y2][0] - dp[x2][y1 - 1][0] + dp[x1 - 1][y1 - 1][0])
          .append("\n");
    }

    System.out.println(sb);
  }
}