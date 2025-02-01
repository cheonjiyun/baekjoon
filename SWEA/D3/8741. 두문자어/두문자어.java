import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
  public static void main(String args[]) throws Exception {

    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {
      String result = "";

      String[] words = new String[3];
      for (int i = 0; i < 3; i++) {
        words[i] = sc.next();
      }

      for (String w : words) {
        String first = w.substring(0, 1);
        result += first.toUpperCase();

      }

      System.out.println("#" + test_case + " " + result);
    }
  }
}
