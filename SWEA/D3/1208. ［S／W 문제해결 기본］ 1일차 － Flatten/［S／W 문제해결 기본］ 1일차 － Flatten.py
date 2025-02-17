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
      int dump = Integer.parseInt(in.readLine());
      String[] inputs = in.readLine().split(" ");
      int[] width = new int[100];
      for (int i = 0; i < inputs.length; i++) {
        width[i] = Integer.parseInt(inputs[i]);
      }

      /*
       * 2. 알고리즘 풀기
       */
      for (int i = 0; i < dump; i++) {
        int maxIndex = getMaxIndex(width);
        int minIndex = getMinIndex(width);

        width[minIndex] += 1;
        width[maxIndex] -= 1;
      }

      /*
       * 정답 출력
       */
      int maxIndex = getMaxIndex(width);
      int minIndex = getMinIndex(width);
      int result = width[maxIndex] - width[minIndex];
      sb.append(result).append("\n");
    }

    System.out.println(sb);
  }

  public static int getMinIndex(int[] width) {
    int min = Integer.MAX_VALUE;
    int idx = 0;
    for (int i = 0; i < width.length; i++) {
      if (width[i] <= min) {
        min = width[i];
        idx = i;
      }
    }
    return idx;
  }


  public static int getMaxIndex(int[] width) {
    int max = Integer.MIN_VALUE;
    int idx = 0;
    for (int i = 0; i < width.length; i++) {
      if (width[i] >= max) {
        max = width[i];
        idx = i;
      }
    }
    return idx;
  }
}