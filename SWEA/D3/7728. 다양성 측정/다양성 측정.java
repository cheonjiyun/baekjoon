
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
  public static void main(String args[]) throws Exception {

    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {
      String x = sc.next();

      HashSet<Character> multi = new HashSet<Character>();
      for (char i : x.toCharArray()) {
        multi.add(i);
      }

      System.out.println("#" + test_case + " " + multi.size());
    }
  }
}
