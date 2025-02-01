
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }

      Arrays.sort(a); // 큰 수끼리 뭉치자??

      int result = 0;
      result += n; // 앉아있는 사람
      result += a[0]; // 맨 왼쪽
      result += a[n - 1]; // 맨 오른쪽
      for (int i = 1; i < n; i++) {
        result += Math.max(a[i], a[i - 1]);
      }

      System.out.println("#" + test_case + " " + result);
    }
  }
}
