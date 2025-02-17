import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
  public static void main(String[] args) throws Exception {

    /**
     * 0. 입력파일 읽어들이기
     */
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    // 결과를 한 번에 출력하기 위한 StringBuilder
    StringBuilder sb = new StringBuilder();

    int T = 10;
    for (int test_case = 1; test_case <= T; test_case++) {
      sb.append("#" + test_case + " ");

      // 여러분의 알고리즘 코드 작성하기

      /*
       * 1. 입력 파일 객체화
       */

      int n = Integer.parseInt(in.readLine());
      String[] inputs = in.readLine().split(" ");
      int[] buildings = new int[n];
      for (int i = 0; i < buildings.length; i++) {
        buildings[i] = Integer.parseInt(inputs[i]);
      }

      /*
       * 2. 알고리즘 풀기
       */

      int result = 0;
      for (int i = 2; i < buildings.length - 2; i++) {
        int maxViewRight = Integer.MAX_VALUE;

        for (int j = i - 2; j <= i + 2; j++) { // 양옆 두개 순회
          if (i == j) // 본인 제외
            continue;

          int viewRight = buildings[i] - buildings[j]; // 가능한 조망권

          if (viewRight < maxViewRight) { // 더 작은 조망권으로 교체
            maxViewRight = viewRight;
          }
        }
        if (maxViewRight == Integer.MAX_VALUE || maxViewRight < 0)
          maxViewRight = 0;

        result += maxViewRight;
      }

      /*
       * 정답 출력
       */
      sb.append(result).append("\n");
    }

    System.out.println(sb);
  }
}