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

    int[][] dp = new int[n + 1][10];

    for (int i = 1; i < n + 1; i++) {
      if (i == 1) {
        for (int j = 1; j <= 9; j++) {
          dp[i][j] = 1;
        }
      } else {
        dp[i][0] = dp[i - 1][1];
        dp[i][9] = dp[i - 1][8];

        for (int j = 1; j < 9; j++) {
          dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
        }
      }
    }

    int result = 0;
    for (int j = 0; j < 10; j++) {
      result = (result + dp[n][j]) % 1000000000;
    }

    sb.append(result % 1000000000);


    System.out.println(sb);
  }
}