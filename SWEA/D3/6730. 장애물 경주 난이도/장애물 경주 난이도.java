import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

class Solution {
  public static void main(String args[]) throws Exception {

    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {
      int n = sc.nextInt();

      ArrayList<Integer> block = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        block.add(sc.nextInt());
      }

      int resultUp = 0;
      int resultDown = 0;
      for (int i = 0; i < n - 1; i++) {
        int left = block.get(i);
        int right = block.get(i + 1);

        if (left - right < 0) { // 음수 => 올라가기
          if (resultUp < right - left) {
            resultUp = right - left;
          }
        } else {
          if (resultDown < left - right) {
            resultDown = left - right;
          }
        }
      }
      System.out.println("#" + test_case + " " + resultUp + " " + resultDown);
    }
  }
}
