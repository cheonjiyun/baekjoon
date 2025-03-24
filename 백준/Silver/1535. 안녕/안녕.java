import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[][] dp;
  static int[] tired;
  static int[] happy;

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int n = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine().trim());
    tired = new int[n + 1];
    for (int i = 1; i < n + 1; i++) {
      tired[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine().trim());
    happy = new int[n + 1];
    for (int i = 1; i < n + 1; i++) {
      happy[i] = Integer.parseInt(st.nextToken());
    }


    dp = new int[n + 1][101];
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j <= 100; j++) {
        dp[i][j] = -1;
      }
    }

    sb.append(topDown(n, 100));
    System.out.println(sb);
  }

  static int topDown(int idx, int hp) {
    if (idx == 0)
      return 0;
    if (dp[idx][hp] == -1) {
      if (hp > tired[idx]) { // 충분한 체력이 있는 경우
        // 선택안하는 경우,
        // 선택안하면 i-1번째 선택한 것중 hp 그대로 최댓값 가져오면 됨
        // 선택하면 i-1번째 중 hp - 피로도 뺀거의 최대
        dp[idx][hp] =
            Math.max(topDown(idx - 1, hp), topDown(idx - 1, hp - tired[idx]) + happy[idx]);
      } else {
        // 어차피 못챙김
        dp[idx][hp] = topDown(idx - 1, hp);
      }
    }

    return dp[idx][hp];
  }
}