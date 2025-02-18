import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
  public static void main(String[] args) throws Exception {

    /**
     * 0. 입력파일 읽어들이기
     */
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    // 결과를 한 번에 출력하기 위한 StringBuilder
    StringBuilder sb = new StringBuilder();

    for (int test_case = 1; test_case <= 10; test_case++) {
      sb.append("#" + test_case + " ");

      int T = Integer.parseInt(in.readLine());
      // 여러분의 알고리즘 코드 작성하기

      /*
       * 1. 입력 파일 객체화
       */

      int[][] arr = new int[100][100];
      for (int i = 0; i < 100; i++) {
        String[] inputs = in.readLine().split(" ");
        for (int j = 0; j < 100; j++) {
          arr[i][j] = Integer.parseInt(inputs[j]);
        }
      }

      /*
       * 2. 알고리즘 풀기
       */

      int result = 0;

      // 가로
      for (int y = 0; y < 100; y++) {
        int sumRow = 0;
        for (int x = 0; x < 100; x++) {
          sumRow += arr[y][x];
        }
        result = Math.max(sumRow, result);
      }

      // 세로
      for (int x = 0; x < 100; x++) {
        int sumRow = 0;
        for (int y = 0; y < 100; y++) {
          sumRow += arr[y][x];
        }
        result = Math.max(sumRow, result);
      }

      // 대각선 좌상 우하
      int sumRow = 0;
      for (int y = 0; y < 100; y++) {
        sumRow += arr[y][y];
      }
      result = Math.max(sumRow, result);

      // 대각선 우상 좌하
      sumRow = 0;
      for (int y = 0; y < 100; y++) {
        sumRow += arr[y][99 - y];
      }

      result = Math.max(sumRow, result);


      /*
       * 정답 출력
       */
      sb.append(result).append("\n");
    }

    System.out.println(sb);
  }
}