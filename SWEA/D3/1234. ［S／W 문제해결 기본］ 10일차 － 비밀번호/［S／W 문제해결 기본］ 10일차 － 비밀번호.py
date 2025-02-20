import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

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

      String[] input = in.readLine().split(" ");
      Deque<Character> stack = new ArrayDeque<Character>();
      int n = Integer.parseInt(input[0]);
      for (char c : input[1].toCharArray()) {

        if (!stack.isEmpty() && stack.peekLast() == c) {
          stack.removeLast();
        } else {
          stack.addLast(c);
        }
      }

      for (char c : stack) {
        sb.append(c);
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}