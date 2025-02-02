
import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
  public static void main(String args[]) throws Exception {

    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {
      String input = sc.next();
      String[] chars = input.split("");

      int[] freq = new int[10];
      for (String s : chars) {
        freq[Integer.valueOf(s)] += 1;
      }

      int result = 0;
      for (int f : freq) {
        if (f % 2 == 1) {
          result += 1;
        }
      }

      System.out.println("#" + test_case + " " + result);
    }
  }
}
