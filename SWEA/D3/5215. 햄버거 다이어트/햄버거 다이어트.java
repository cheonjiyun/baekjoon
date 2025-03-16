import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  private static int N;
  private static int maxScore;
  private static int L;
  private static Material[] materials;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int T = Integer.parseInt(st.nextToken());

    for (int testCase = 1; testCase <= T; testCase++) {
      st = new StringTokenizer(br.readLine().trim());
      N = Integer.parseInt(st.nextToken());
      L = Integer.parseInt(st.nextToken());

      materials = new Material[N];
      for (int i = 0; i < N; i++) {

        st = new StringTokenizer(br.readLine().trim());
        int t = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        materials[i] = new Material(t, k);
      }

      maxScore = 0;
      dfs(0, 0, 0);
      sb.append("#").append(testCase).append(" ");
      sb.append(maxScore).append("\n");
    }
    System.out.println(sb);

  }

  static void dfs(int cnt, int sumScore, int sumCalorie) {
    if (sumCalorie > L) {
      return;
    }

    if (cnt == N) {
      if (maxScore < sumScore) {
        maxScore = sumScore;
      }
      return;
    }

    dfs(cnt + 1, sumScore + materials[cnt].score, sumCalorie + materials[cnt].calorie);
    dfs(cnt + 1, sumScore, sumCalorie);
  }

  static class Material {
    int score;
    int calorie;

    public Material(int score, int calorie) {
      super();
      this.score = score;
      this.calorie = calorie;
    }
  }
}