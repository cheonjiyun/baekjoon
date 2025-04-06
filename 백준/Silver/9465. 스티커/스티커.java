import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private static int n;
  private static int[][] sticker;

  static int result = 0;
  private static int[][] dp;

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int T = Integer.parseInt(st.nextToken());


    for (int test_case = 1; test_case <= T; test_case++) {
      result = 0;

      st = new StringTokenizer(br.readLine().trim());
      n = Integer.parseInt(st.nextToken());

      sticker = new int[2][n + 1];
      for (int i = 0; i < 2; i++) {
        st = new StringTokenizer(br.readLine().trim());
        for (int j = 1; j <= n; j++) {
          sticker[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      dp = new int[2][n + 1];

      dp[0][1] = sticker[0][1];
      dp[1][1] = sticker[1][1];
      for (int i = 2; i <= n; i++) {

        dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
        dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];

      }


      sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
    }

    System.out.println(sb);
  }

}