import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, 1, 0, -1};
  private static int[][] arr;
  private static int n;
  private static int m;
  private static int k;

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine().trim());
      String[] line = st.nextToken().split("");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(line[j]);
      }
    }

    sb.append(bfs());


    System.out.println(sb);
  }

  static int bfs() {
    Queue<Node> q = new LinkedList<Node>();
    q.offer(new Node(0, 0, k, 1));

    boolean visited[][][] = new boolean[n][m][k + 1];
    visited[0][0][1] = true;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.row == n - 1 && cur.col == m - 1) {
        return cur.count;
      }


      for (int d = 0; d < 4; d++) {
        int nRow = cur.row + dr[d];
        int nCol = cur.col + dc[d];

        if (nRow < 0 || nCol < 0 || nRow >= n || nCol >= m) {
          continue;
        }

        if (arr[nRow][nCol] == 0 && !visited[nRow][nCol][cur.k]) {
          visited[nRow][nCol][cur.k] = true;
          q.offer(new Node(nRow, nCol, cur.k, cur.count + 1));
        }
        if (arr[nRow][nCol] == 1 && cur.k >= 1 && !visited[nRow][nCol][cur.k - 1]) {
          visited[nRow][nCol][cur.k - 1] = true;
          q.offer(new Node(nRow, nCol, cur.k - 1, cur.count + 1));
        }
      }
    }

    return -1;
  }

  static class Node {
    int row;
    int col;
    int k;
    int count;

    public Node(int row, int col, int k, int count) {
      super();
      this.row = row;
      this.col = col;
      this.k = k;
      this.count = count;
    }

    @Override
    public String toString() {
      return "Node [row=" + row + ", col=" + col + ", k=" + k + ", count=" + count + "]";
    }
  }
}