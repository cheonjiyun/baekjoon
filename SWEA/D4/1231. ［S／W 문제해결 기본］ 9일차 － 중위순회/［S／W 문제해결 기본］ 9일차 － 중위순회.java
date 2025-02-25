import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    for (int test_case = 1; test_case <= 10; test_case++) {
      sb.append("#").append(test_case).append(" ");

      int n = Integer.parseInt(in.readLine());
      int result = 1;

      String[] arr = new String[n + 1];
      for (int i = 1; i <= n; i++) {
        String[] input = in.readLine().split(" ");

        String a = input[1];
        arr[i] = a;
      }

      inOrder(1, arr, sb);
      sb.append("\n");

    }

    System.out.println(sb);
  }

  private static void inOrder(int i, String[] arr, StringBuilder sb) {

    if (i >= arr.length)
      return;

    inOrder(i * 2, arr, sb);

    sb.append(arr[i]);

    inOrder(i * 2 + 1, arr, sb);

  }


}