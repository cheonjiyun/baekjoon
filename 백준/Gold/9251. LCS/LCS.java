import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    char[] a = br.readLine().toCharArray();
    char[] b = br.readLine().toCharArray();

    int[][] dp = new int[a.length + 1][b.length + 1];

    for (int i = 1; i < a.length + 1; i++) {
      for (int j = 1; j < b.length + 1; j++) {
        if (a[i - 1] == b[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    sb.append(dp[a.length][b.length]);


    System.out.println(sb);
  }
}