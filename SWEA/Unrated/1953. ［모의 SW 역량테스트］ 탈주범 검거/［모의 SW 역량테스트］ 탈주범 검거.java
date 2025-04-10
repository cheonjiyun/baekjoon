import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 탈주범검거
public class Solution {

  public static int[] dr = {-1, 0, 1, 0};
  public static int[] dc = {0, 1, 0, -1};
  public static int[][] kindof =
      new int[][] {{}, {0, 1, 2, 3}, {0, 2}, {1, 3}, {0, 1}, {1, 2}, {2, 3}, {0, 3}};



  public static void main(String[] args) throws Exception {

    //System.setIn(new FileInputStream("src/swea1953모의/sample_input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int T = Integer.parseInt(st.nextToken());

    for (int test_case = 1; test_case <= T; test_case++) {
      sb.append("#" + test_case + " ");

      st = new StringTokenizer(br.readLine().trim());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int l = Integer.parseInt(st.nextToken());

      int[][] arr = new int[n][m];
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine().trim());
        for (int j = 0; j < m; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      // for (int i = 0; i < n; i++) {
      // for (int j = 0; j < m; j++) {
      // System.out.print(arr[i][j] + " ");
      // }
      // System.out.println();
      // }

      Queue<int[]> q = new ArrayDeque<int[]>();
      q.offer(new int[] {r, c});

      boolean[][] visited = new boolean[n][m];
      visited[r][c] = true;

      int result = 0;

      for (int t = 0; t < l; t++) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
          int[] cur = q.poll();
          int curRow = cur[0];
          int curCol = cur[1];
          result++;

          int curKindeof = arr[curRow][curCol];

          for (int d : kindof[curKindeof]) {
            int nRow = curRow + dr[d];
            int nCol = curCol + dc[d];

            if (nRow < 0 || nRow >= n || nCol < 0 || nCol >= m || arr[nRow][nCol] == 0
                || visited[nRow][nCol])
              continue;

            int nextKindof = arr[nRow][nCol];
            boolean canGo = false;
            for (int nextDirection : kindof[nextKindof]) {
              // 다음 파이프 로 갈 수 있는지
              // 방향을 180도 돌린 방향이 있는지 확인
              if ((d + 2) % 4 == nextDirection) {
                canGo = true;
              }
            }

            if (canGo) {
              q.offer(new int[] {nRow, nCol});
              visited[nRow][nCol] = true;
            }

          }

        }
      }


      sb.append(result).append("\n");

    }

    System.out.println(sb);
  }
}