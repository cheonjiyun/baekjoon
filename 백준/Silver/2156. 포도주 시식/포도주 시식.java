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

    int[] glasses = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine().trim());
      glasses[i] = Integer.parseInt(st.nextToken());
    }

    int[][] dp = new int[n][2]; // i번째 와인 먹은 경우 / 안먹은 경우 최대값

    for (int i = 0; i < n; i++) {
      if (i == 0) {
        dp[i][0] = glasses[i];
      } else if (i == 1) {
        dp[i][0] = glasses[i] + glasses[i - 1];
        dp[i][1] = dp[i - 1][0];
      } else {
        dp[i][0] = Math.max(dp[i - 2][1] + glasses[i - 1], dp[i - 1][1]) + glasses[i];
        dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
      }
    }

    sb.append(Math.max(dp[n - 1][0], dp[n - 1][1]));

    System.out.println(sb);
  }
}
