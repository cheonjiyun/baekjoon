
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};
  private static int[][] arr;
  private static int[][] newArr;
  private static int R;
  private static int L;
  private static int N;


  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    arr = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine().trim());

      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int result = 0;
    while (true) {
      boolean flag = true;
      boolean[][] visited = new boolean[N][N];

      // 변경될 배열
      newArr = new int[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          newArr[i][j] = arr[i][j];
        }
      }

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j]) {
            int bfs = bfs(i, j, visited);
            if (bfs > 1) {
              flag = false;
            }
          }
        }
      }

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          arr[i][j] = newArr[i][j];
        }
      }
      if (flag) {
        break;
      }

      result++;
    }

    sb.append(result);

    System.out.println(sb);
  }

  public static int bfs(int i, int j, boolean[][] visited) {
    List<int[]> list = new ArrayList<>(); // 나중에 인구 업데이트할 때 쓸 예정
    int sum = 0;

    Queue<int[]> q = new ArrayDeque<int[]>();
    q.offer(new int[] {i, j});

    visited[i][j] = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int row = cur[0];
      int col = cur[1];

      list.add(cur);
      sum += newArr[row][col];

      for (int d = 0; d < 4; d++) {
        int nrow = row + dr[d];
        int ncol = col + dc[d];

        if (nrow < 0 || nrow >= N || ncol < 0 || ncol >= N)
          continue;

        int dff = Math.abs(newArr[row][col] - newArr[nrow][ncol]);

        if (!visited[nrow][ncol] && dff >= L && dff <= R) {
          visited[nrow][ncol] = true;
          q.offer(new int[] {nrow, ncol});
        }
      }
    }

    for (int idx = 0; idx < list.size(); idx++) {
      int row = list.get(idx)[0];
      int col = list.get(idx)[1];

      newArr[row][col] = sum / list.size();
    }
    return list.size();
  }
}
