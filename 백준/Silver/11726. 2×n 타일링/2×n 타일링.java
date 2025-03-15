import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int[] memo;

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int n = Integer.parseInt(st.nextToken());
    memo = new int[n + 1];
    // sb.append(dfs(1));

    sb.append(dp(n));

    System.out.println(sb);
  }

  private static int dp(int n) {

    if (memo[n] == 0) {

      if (n == 1) {
        memo[1] = 1;
      } else if (n == 2) {
        memo[2] = 2;
      } else {
        memo[n] = (dp(n - 1) + dp(n - 2)) % 10007; // n-1에 세로 하나 넣는거랑, n-2에 가로 두개넣는거랑
      }
    }


    return memo[n];

  }

  // static int dfs(int cnt) {
  //
  // if (cnt == n) {
  // return 1;
  // }
  // if (cnt == n - 1) {
  // return 2;
  // }
  //
  //
  // int sum = 0;
  // sum += dfs(cnt + 1);
  // sum += dfs(cnt + 2);
  //
  // return sum % 10007;
  // }

}