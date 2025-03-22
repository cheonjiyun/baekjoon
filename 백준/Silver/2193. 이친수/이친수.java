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

    long[][] dp = new long[n + 1][2]; // 0으로 끝나는 경우의 수 / 1로 끝나는 경우의 수

    for (int i = 1; i < n + 1; i++) {
      if (i == 1) {
        dp[i][0] = 0;
        dp[i][1] = 1;
      } else if (i == 2) {
        dp[i][0] = 1;
        dp[i][1] = 0;
      } else if (i == 3) {
        dp[i][0] = 1;
        dp[i][1] = 1;
      } else {
        dp[i][0] = dp[i - 1][0] + dp[i - 1][1]; // 0은 0와 1 뒤에 모두 가능
        dp[i][1] = dp[i - 1][0]; // 1을 붙이려면 0뒤에만만 가능
      }
    }

    sb.append(dp[n][0] + dp[n][1]);

    System.out.println(sb);
  }

}
