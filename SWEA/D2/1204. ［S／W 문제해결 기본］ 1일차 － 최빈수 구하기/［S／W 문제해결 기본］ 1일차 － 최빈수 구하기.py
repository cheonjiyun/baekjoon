import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

  private static int[] counter;

  public static void main(String[] args) throws Exception {

    /**
     * 0. 입력파일 읽어들이기
     */
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    // 결과를 한 번에 출력하기 위한 StringBuilder
    StringBuilder sb = new StringBuilder();

    int T;
    T = Integer.parseInt(in.readLine());
    for (int test_case = 1; test_case <= T; test_case++) {
      sb.append("#" + test_case + " ");

      // 여러분의 알고리즘 코드 작성하기
      /**
       * 1. 입력 파일 객체화
       */
      in.readLine();
      String[] scores = in.readLine().split(" ");
      counter = new int[101];


      /*
       * 2. 알고리즘 풀기
       */
      for (int i = 0; i < scores.length; i++) {
        int score = Integer.parseInt(scores[i]);
        counter[score]++; // 점수카운팅
      }
      /*
       * 정답 출력
       */
      int max = Integer.MIN_VALUE;
      int answer = -1;
      for (int score = 0; score <= 100; score++) {
        // 같다까지 해야 가장 큰 점수가 answer에 저장됨
        if (max <= counter[score]) {
          max = counter[score];
          answer = score;
        }
      }
      sb.append(answer).append("\n");
    }
    System.out.println(sb);
  }
}