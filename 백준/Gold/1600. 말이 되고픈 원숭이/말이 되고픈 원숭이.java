import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[] dx = {0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1};
  static int[] dy = {-1, 0, 1, 0, -2, -1, 1, 2, 2, 1, -1, -2};
  private static int h;
  private static int w;
  private static int k;
  private static int[][] world;

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    k = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine().trim());
    w = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    world = new int[h][w];
    for (int i = 0; i < h; i++) {
      st = new StringTokenizer(br.readLine().trim());

      for (int j = 0; j < w; j++) {
        world[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // for (int i = 0; i < h; i++) {
    //
    // for (int j = 0; j < w; j++) {
    // System.out.print(world[i][j]);
    // }
    // System.out.println();
    // }

    // 완전탐색
    sb.append(bfs(0, 0));

    System.out.println(sb);
  }

  // 방문처리를 어떻게??
  // count 와 k 사용횟수

  private static int bfs(int x, int y) {

    int[][] visited = new int[h][w];

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        visited[i][j] = -1;
      }
    }
    visited[y][x] = k + 1;

    Queue<Node> q = new ArrayDeque<Node>();
    q.offer(new Node(x, y, 0, k));

    while (!q.isEmpty()) {
      Node cur = q.poll();

      // 장애물
      if (world[cur.y][cur.x] == 1) {
        continue;
      }

      // 도착
      if (cur.x == w - 1 && cur.y == h - 1) {
        return cur.count;
      }

      // 원숭이, 말
      for (int d = 0; d < 12; d++) {
        int nx = dx[d] + cur.x;
        int ny = dy[d] + cur.y;

        // 범위
        if (isOut(nx, ny))
          continue;

        // k 소진
        int newK = cur.k;
        if (d >= 4) {
          if (newK <= 0) { // 말로 갈 수 없다면
            continue;
          }
          newK--; // k감소

        }

        // 장애물
        if (world[ny][nx] == 1) {
          continue;
        }

        if (visited[ny][nx] >= newK)
          continue;



        visited[ny][nx] = newK;
        q.offer(new Node(nx, ny, cur.count + 1, newK));

      }
    }
    return -1;
  }

  private static boolean isOut(int x, int y) {
    if (x < 0 || y < 0 || x >= w || y >= h)
      return true;
    else
      return false;
  }

  static class Node {
    int x;
    int y;
    int count;
    int k;

    public Node(int x, int y, int count, int k) {
      super();
      this.x = x;
      this.y = y;
      this.count = count;
      this.k = k;
    }

    @Override
    public String toString() {
      return "Node [x=" + x + ", y=" + y + ", count=" + count + ", k=" + k + "]";
    }

  }
}