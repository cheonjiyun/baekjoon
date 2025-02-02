import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
  public static void main(String args[]) throws Exception {

    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {
      int n = sc.nextInt();
      int m = sc.nextInt();

      String result = "ON";
      for (int i = 0; i < n; i++) {
        int bit = 1 << i; // 비트 연산으로 0100 왼쪽으로 하나씩 미룬다
        if ((bit & m) != bit) { // & 연산으로 통과했을 때 bit과 같으면 그 자리가 1로 켜져있다.
          result = "OFF";
        }
      }

      System.out.println("#" + test_case + " " + result);
    }
  }
}
