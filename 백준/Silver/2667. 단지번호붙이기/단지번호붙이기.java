import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {-1, 0, 1, 0};

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int n = Integer.parseInt(st.nextToken());


    int[][] map = new int[n][n];
    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split("");

      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(line[j]);
      }

    }

    List<Integer> house = new ArrayList<Integer>();
    int danji = 2; // 단지

    for (int i = 0; i < n; i++) {

      for (int j = 0; j < n; j++) {

        if (map[i][j] == 1) {
          // bfs
          int count = 0;
          Queue<XY> q = new ArrayDeque<>();
          q.offer(new XY(j, i));

          map[i][j] = danji;

          while (!q.isEmpty()) {
            XY cur = q.poll();
            count++;

            for (int d = 0; d < 4; d++) {
              int nx = cur.x + dx[d];
              int ny = cur.y + dy[d];

              if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[ny][nx] == 1) {

                map[ny][nx] = danji;
                q.offer(new XY(nx, ny));
              }

            }
          }
          house.add(count);
          danji++; // 단지 하나씩 올려가면서

        }



      }

    }

    Collections.sort(house);

    sb.append(house.size()).append("\n");

    for (int home : house) {
      sb.append(home).append("\n");
    }

    // System.out.println();
    // for (int i = 0; i < n; i++) {
    // for (int j = 0; j < n; j++) {
    // System.out.print(map[i][j]);
    // }
    // System.out.println();
    // }
    // System.out.println();

    System.out.println(sb);
  }

  static class XY {
    int x;
    int y;

    public XY(int x, int y) {
      super();
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "XY [x=" + x + ", y=" + y + "]";
    }


  }
}