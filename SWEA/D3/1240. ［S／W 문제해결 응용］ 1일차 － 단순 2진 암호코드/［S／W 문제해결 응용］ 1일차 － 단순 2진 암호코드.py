import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int T = Integer.parseInt(st.nextToken());

    for (int test_case = 1; test_case <= T; test_case++) {
      sb.append("#" + test_case + " ");
      st = new StringTokenizer(br.readLine().trim());

      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      int[][] arr = new int[n][m];

      int x = 0;
      int y = 0;
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine().trim());
        String[] input = st.nextToken().split("");
        for (int j = 0; j < m; j++) {
          int value = Integer.parseInt(input[j]);
          arr[i][j] = value;

          // 기록
          if (value == 1) {
            y = i;
            x = j;
          }
          // System.out.print(arr[i][j]);
        }
        // System.out.println();
      }

      x -= 7 * 8; // 암호 시작점
      x += 1;

      HashMap<String, Integer> ciyper = new HashMap<String, Integer>();
      ciyper.put("0001101", 0);
      ciyper.put("0011001", 1);
      ciyper.put("0010011", 2);
      ciyper.put("0111101", 3);
      ciyper.put("0100011", 4);
      ciyper.put("0110001", 5);
      ciyper.put("0101111", 6);
      ciyper.put("0111011", 7);
      ciyper.put("0110111", 8);
      ciyper.put("0001011", 9);

      List<String> numbers = new ArrayList<>();

      for (int i = x; i < x + 7 * 8; i += 7) {
        String num = "";

        for (int j = i; j < i + 7; j++) {
          num += arr[y][j];
        }

        numbers.add(num);
      }

      int correct = 0;
      int sum = 0;
      for (int i = 0; i < 8; i += 2) {
        correct += ciyper.get(numbers.get(i));
        sum += ciyper.get(numbers.get(i));
      }
      correct *= 3;
      for (int i = 1; i < 8; i += 2) {
        correct += ciyper.get(numbers.get(i));
        sum += ciyper.get(numbers.get(i));
      }

      sb.append(correct % 10 == 0 ? sum : 0).append("\n");
    }

    System.out.println(sb);
  }
}