import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, 1, 0, -1};

  public static void main(String[] args) throws Exception {

    //System.setIn(new FileInputStream("src/swea22654/sample_input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int T = Integer.parseInt(st.nextToken());

    for (int test_case = 1; test_case <= T; test_case++) {
      sb.append("#" + test_case + " ");

      st = new StringTokenizer(br.readLine().trim());
      int n = Integer.parseInt(st.nextToken());

      char[][] arr = new char[n][n];
      for (int i = 0; i < n; i++) {
        arr[i] = br.readLine().toCharArray();
      }

      int[] start = new int[2];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (arr[i][j] == 'X') {
            start[0] = i;
            start[1] = j;
          }
        }
      }


      st = new StringTokenizer(br.readLine().trim());
      int q = Integer.parseInt(st.nextToken());

      for (int i = 0; i < q; i++) {
        st = new StringTokenizer(br.readLine().trim());
        int size = Integer.parseInt(st.nextToken());

        int rotate = 0;
        int[] current = new int[2];
        current[0] = start[0];
        current[1] = start[1];

        char[] commands = st.nextToken().toCharArray();
        for (char command : commands) {
          if (command == 'A') {
            int nr = current[0] + dr[rotate];
            int nc = current[1] + dc[rotate];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n || arr[nr][nc] == 'T')
              continue;

            current[0] = nr;
            current[1] = nc;

          } else if (command == 'L') {
            rotate = (rotate + 4 - 1) % 4;
          } else if (command == 'R') {
            rotate = (rotate + 4 + 1) % 4;
          }
        }


        sb.append(arr[current[0]][current[1]] == 'Y' ? 1 : 0).append(" ");
      }

      sb.append("\n");
      // for (int i = 0; i < n; i++) {
      // for (int j = 0; j < n; j++) {
      // System.out.print(arr[i][j]);
      // }
      // System.out.println();
      // }
      // System.out.println();
    }


    System.out.println(sb);
  }
}