import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static Integer dp[];
  static int arr[];

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int n = Integer.parseInt(st.nextToken());

    dp = new Integer[n + 1];
    arr = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    dp[0] = arr[0]; // 디폴트값이 null이므로 0으로 초기화 해주어야한다.
    dp[1] = arr[1];

    if (n >= 2) {
      dp[2] = arr[1] + arr[2];
    }
    sb.append(find(n));

    System.out.println(sb);
  }

  private static int find(int n) {
    if (dp[n] == null) {
      dp[n] = Math.max(find(n - 2), find(n - 3) + arr[n - 1]) + arr[n];
    }
    return dp[n];
  }

  // public static int dfs(int cnt, int continuous) {
  // if (cnt == n - 1) {
  // return stairs[cnt];
  // }
  //
  // int max = 0;
  // if (continuous < 1) {
  // if (cnt + 1 < n) {
  // max = Math.max(max, stairs[cnt] + dfs(cnt + 1, continuous + 1));
  //
  // }
  // }
  // if (cnt + 2 < n) {
  // max = Math.max(max, stairs[cnt] + dfs(cnt + 2, 0));
  //
  // }
  // return max;
  // }
}