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

    int[] dp = new int[n + 1];

    for (int i = 1; i < n + 1; i++) {
      if (i == 1) {
        dp[i] = 1;
      } else if (i == 2) {
        dp[i] = 3;
      } else {
        dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
      }

    }

    sb.append(dp[n]);


    System.out.println(sb);
  }
}