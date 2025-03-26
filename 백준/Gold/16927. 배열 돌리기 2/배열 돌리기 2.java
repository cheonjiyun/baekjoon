import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());

    int[][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine().trim());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }


    int min = Math.min(n, m) / 2;

    for (int i = 0; i < min; i++) {
      int cnt = r % (((n - 2 * i) + (m - 2 * i)) * 2 - 4);

      for (int z = 0; z < cnt; z++) {

        int x = i;
        int y = i;
        int temp = arr[y][x];

        int dir = 0;

        while (dir < 4) {
          int nx = x + dx[dir];
          int ny = y + dy[dir];

          if (nx < i || ny < i || nx >= m - i || ny >= n - i) {
            dir++; // 범위에 벗어나면 방향 바꿈
            continue;
          }

          arr[y][x] = arr[ny][nx];
          y = ny;
          x = nx;
        }

        arr[i + 1][i] = temp;
      }

    }

    for (

        int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
}