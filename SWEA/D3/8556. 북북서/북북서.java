import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();
    for (int test_case = 1; test_case <= T; test_case++) {
      String dest = sc.next();

      String current = "";
      double wordCount = 0;
      double result = 0;
      for (int i = dest.length() - 1; i >= 0; i--) {
        current = dest.substring(i, i + 1) + current;
        if (!(current.equals("west") || current.equals("north")))
          continue;
        double addDir = (90 / Math.pow(2.0, wordCount));
        if (current.equals("west")) {
          if (wordCount == 0) {
            result += 90;
          } else {
            result += addDir;
          }
        }
        if (current.equals("north")) {
          if (wordCount != 0) {
            result -= addDir;
          }

        }
        wordCount += 1;
        current = "";

      }

      int denominator = 1;
      while (result % 1 != 0) {
        result *= 2;
        denominator *= 2;
      }

      String answer = String.valueOf((int) result);
      if (denominator != 1) {
        answer += "/" + denominator;
      }
      System.out.println("#" + test_case + " " + answer);
    }
  }
}