
import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {
      int n = sc.nextInt();

      String problem = sc.next();
      String answer = sc.next();

      int result = 0;
      for (int i = 0; i < n; i++) {
        if (problem.charAt(i) == answer.charAt(i)) {
          result += 1;
        }
      }

      System.out.println("#" + test_case + " " + result);
    }
  }
}
