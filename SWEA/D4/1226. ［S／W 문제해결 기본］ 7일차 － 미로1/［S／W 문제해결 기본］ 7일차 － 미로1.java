import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    for (int test_case = 1; test_case <= 10; test_case++) {
      StringTokenizer st = new StringTokenizer(br.readLine().trim());
      int T = Integer.parseInt(st.nextToken());
      sb.append("#" + T + " ");

      int[][] arr = new int[16][16];
      int[] start = new int[2];
      int[] end = new int[2];
      for (int i = 0; i < 16; i++) {
        String[] line = br.readLine().split("");
        for (int j = 0; j < 16; j++) {
          arr[i][j] = Integer.parseInt(line[j]);
          if (arr[i][j] == 2) {
            start[0] = i;
            start[1] = j;
          } else if (arr[i][j] == 2) {
            end[0] = i;
            end[1] = j;
          }
        }
      }

      Queue<int[]> q = new ArrayDeque<int[]>();
      q.add(start);

      boolean[][] visited = new boolean[16][16];
      visited[start[0]][start[1]] = true;

      int result = 0;

      bfs: while (!q.isEmpty()) {
        int[] cur = q.poll();
        int curRow = cur[0];
        int curCol = cur[1];

        for (int d = 0; d < 4; d++) {
          int nextRow = curRow + dr[d];
          int nextCol = curCol + dc[d];

          if (nextRow >= 0 && nextRow < 16 && nextCol >= 0 && nextCol < 16
              && !visited[nextRow][nextCol]) {
            if (arr[nextRow][nextCol] == 0) {
              q.add(new int[] {nextRow, nextCol});
              visited[nextRow][nextCol] = true;

            } else if (arr[nextRow][nextCol] == 3) {
              result = 1;
              break bfs;
            }
          }

        }
      }

      sb.append(result).append("\n");

    }

    System.out.println(sb);
  }
}