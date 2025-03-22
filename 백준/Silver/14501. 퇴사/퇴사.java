
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int n = Integer.parseInt(st.nextToken());

    int[][] counseling = new int[n + 1][2];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine().trim());
      counseling[i][0] = Integer.parseInt(st.nextToken());
      counseling[i][1] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[n + 1];
    for (int i = n; i >= 0; i--) {
      int t = counseling[i][0];
      int p = counseling[i][1];



      if (i + t <= n + 1) { // 하루에 끝나면
        dp[i] = p;
      }

      if (i + 1 < n + 1 && dp[i] < dp[i + 1]) { // i번쨰 날에는 상담 안함
        dp[i] = dp[i + 1];
      }

      if (i + t < n + 1 && dp[i] < p + dp[i + t]) { // i번째 상담하고 건너뛰고 나머지
        dp[i] = p + dp[i + t];
      }

    }

    sb.append(dp[1]);
    System.out.println(sb);
  }
}
