import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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

      String[] strings = new String[3];
      for (int i = 0; i < 3; i++) {
        strings[i] = br.readLine();
      }

      // 1.
      int count = 0;
      for (int i = 0; i < n; i++) {
        int[] arr = new int[26];
        for (int j = 0; j < 3; j++) {
          arr[strings[j].charAt(i) - 'a'] += 1;
        }

        boolean isTwo = false;
        boolean isThree = false;
        for (int a = 0; a < arr.length; a++) {
          // 똑같은거 2개 있으면 하나만 바꾸면 됨.
          if (arr[a] == 2) {
            isTwo = true;
          }
          if (arr[a] == 3) {
            isThree = true;
          }
        }
        if (isTwo) {
          count += 1;
        }
        // 다 다르면 두개를 하나에 맞춰야함
        if (!isTwo && !isThree) {
          count += 2;
        }
      }

      sb.append(count);
      sb.append("\n");
    }


    System.out.println(sb);
  }
}