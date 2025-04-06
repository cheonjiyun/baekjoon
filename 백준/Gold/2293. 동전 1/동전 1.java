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
    int k = Integer.parseInt(st.nextToken());

    int[] coin = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine().trim());
      coin[i] = Integer.parseInt(st.nextToken());
    }


    int[] dp = new int[k + 1];
    dp[0] = 1;

    for (int i = 1; i <= n; i++) {

      for (int money = 1; money <= k; money++) {

        if (money - coin[i] >= 0) {
          dp[money] += dp[money - coin[i]];

        }
      }
    }

    sb.append(dp[k]);


    System.out.println(sb);
  }
}