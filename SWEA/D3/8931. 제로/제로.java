import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

class Solution {
  public static void main(String args[]) throws Exception {

    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {

      int k = sc.nextInt();
      Stack<Integer> stackInt = new Stack<>();

      for (int i = 0; i < k; i++) {
        int number = sc.nextInt();
        if (number != 0) {
          stackInt.push(number);
        } else {
          stackInt.pop();
        }
      }

      System.out
          .println("#" + test_case + " " + stackInt.stream().mapToInt(Integer::intValue).sum());
    }
  }
}
