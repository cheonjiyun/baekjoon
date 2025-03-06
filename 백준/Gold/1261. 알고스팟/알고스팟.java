import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int INF = 10000;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};

  static int m;
  static int n;
  static int[][] maze;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    maze = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine().trim());
      String[] input = st.nextToken().split("");
      for (int j = 0; j < m; j++) {
        maze[i][j] = Integer.parseInt(input[j]);
      }
    }

    sb.append(dijksta());
    System.out.println(sb);
  }


  static int dijksta() {

    int[][] minBreakCount = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        minBreakCount[i][j] = INF;
      }
    }
    minBreakCount[0][0] = 0;

    boolean[][] visited = new boolean[n][m];

    Queue<Node> pq = new PriorityQueue<Node>();
    pq.offer(new Node(0, 0, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (visited[cur.y][cur.x])
        continue;
      visited[cur.y][cur.x] = true;

      if (cur.x == n - 1 && cur.y == m - 1)
        break;

      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + cur.x;
        int ny = dy[i] + cur.y;

        if (isWall(nx, ny))
          continue;

        int newBreakCount = cur.breakCount + maze[ny][nx]; // 있으면 부숨

        if (minBreakCount[ny][nx] > newBreakCount) {
          minBreakCount[ny][nx] = newBreakCount;
          pq.offer(new Node(nx, ny, minBreakCount[ny][nx]));
        }

      }
    }

    return minBreakCount[n - 1][m - 1];

  }

  static boolean isWall(int x, int y) {
    if (x < 0 || y < 0 || x >= m || y >= n)
      return true;
    else
      return false;
  }

  static class Node implements Comparable<Node> {
    int x;
    int y;
    int breakCount;

    public Node(int x, int y, int breakCount) {
      super();
      this.x = x;
      this.y = y;
      this.breakCount = breakCount;
    }

    @Override
    public String toString() {
      return "Node [x=" + x + ", y=" + y + ", breakCount=" + breakCount + "]";
    }

    @Override
    public int compareTo(Node o) {
      return this.breakCount - o.breakCount;
    }


  }
}