import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  private static int m;
  private static int n;
  private static int[][] map;
  private static ArrayList<Virus> viruses;

  private static int[] dr = {-1, 0, 1, 0};
  private static int[] dc = {0, 1, 0, -1};

  private static int minInfection = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    viruses = new ArrayList<>();

    map = new int[n][m];

    int floorCount = 0;
    for (int r = 0; r < n; r++) {
      st = new StringTokenizer(br.readLine().trim());
      for (int c = 0; c < m; c++) {
        map[r][c] = Integer.parseInt(st.nextToken());

        if (map[r][c] == 2) {
          viruses.add(new Virus(r, c));
        }
        if (map[r][c] == 0 || map[r][c] == 2) {
          floorCount++;
        }
      }
    }

    // 벽 세우기 dfs
    wallDfs(0);

    // 벽이 아닌 영역 - 가벽3개 - 바이러스퍼진곳
    sb.append(floorCount - minInfection - 3).append("\n");

    System.out.println(sb);
  }

  static class Virus {
    int row;
    int col;

    public Virus(int row, int col) {
      super();
      this.row = row;
      this.col = col;
    }

    @Override
    public String toString() {
      return "Virus [row=" + row + ", col=" + col + "]";
    }


  }

  static void wallDfs(int cnt) {
    if (cnt == 3) {
      // 벽 다 세웠으니 바이러스 퍼트리기
      virusBfs();
      return;
    }

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < m; x++) {
        // 실제로 벽 세우기
        if (map[y][x] == 0) {
          map[y][x] = 1;
          wallDfs(cnt + 1);
          map[y][x] = 0;
        }

      }
    }
  }

  private static void virusBfs() {
    Queue<Virus> q = new ArrayDeque<>(viruses);

    boolean[][] visited = new boolean[n][m];

    int infection = 0;

    while (!q.isEmpty()) {
      Virus cur = q.poll();

      if (visited[cur.row][cur.col])
        continue;

      visited[cur.row][cur.col] = true;

      infection++;

      for (int d = 0; d < dr.length; d++) {
        int nrow = cur.row + dr[d];
        int ncol = cur.col + dc[d];

        if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && map[nrow][ncol] == 0
            && !visited[nrow][ncol]) {

          q.offer(new Virus(nrow, ncol));
        }
      }
    }

    if (minInfection > infection) {
      minInfection = infection;
    }

  }
}
