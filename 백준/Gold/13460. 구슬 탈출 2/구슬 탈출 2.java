import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  private static int[] red;
  private static int[] blue;
  private static int m;
  private static int n;

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    char[][] arr = new char[n][m];
    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine().toCharArray();

    }

    blue = new int[2];
    red = new int[2];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 'B') {
          blue[0] = i;
          blue[1] = j;
        }
        if (arr[i][j] == 'R') {
          red[0] = i;
          red[1] = j;
        }
      }
    }


    // bfs
    Queue<Node> q = new ArrayDeque<Main.Node>();
    q.offer(new Node(red[0], red[1], blue[0], blue[1], 1));

    boolean[][][][] visited = new boolean[n][m][n][m];
    visited[red[0]][red[1]][blue[0]][blue[1]] = true;


    bfs: while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int d = 0; d < 4; d++) {
        int[] redNext = roll(cur.redRow, cur.redCol, d, arr);
        int redNextRow = redNext[0];
        int redNextCol = redNext[1];
        int redDist = redNext[2];

        int[] blueNext = roll(cur.blueRow, cur.blueCol, d, arr);
        int blueNextRow = blueNext[0];
        int blueNextCol = blueNext[1];
        int blueDist = blueNext[2];

        // 파란 공이 구멍에 빠지면 무효
        if (arr[blueNextRow][blueNextCol] == 'O')
          continue;

        // 빨간 공이 구멍에 빠지면 성공
        if (arr[redNextRow][redNextCol] == 'O') {
          result = cur.cnt;
          break bfs;
        }

        // 위치가 겹치면 이동 거리가 큰 쪽을 한 칸 뒤로
        if (redNextRow == blueNextRow && redNextCol == blueNextCol) {
          if (redDist > blueDist) {
            redNextRow -= dr[d];
            redNextCol -= dc[d];
          } else {
            blueNextRow -= dr[d];
            blueNextCol -= dc[d];
          }
        }

        if (!visited[redNextRow][redNextCol][blueNextRow][blueNextCol]) {
          visited[redNextRow][redNextCol][blueNextRow][blueNextCol] = true;

          if (cur.cnt < 10) {
            q.offer(new Node(redNextRow, redNextCol, blueNextRow, blueNextCol, cur.cnt + 1));
          }
        }
      }
    }
    sb.append(result);

    System.out.println(sb);
  }


  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, 1, 0, -1};
  private static int result = -1;


  public static boolean isBead(int row, int col, char[][] arr) {
    if (arr[row][col] == 'R' || arr[row][col] == 'B') {
      return true;
    } else {
      return false;
    }
  }

  public static int[] roll(int row, int col, int direction, char[][] arr) {

    int nextRow = row;
    int nextCol = col;

    int dist = 0;

    while (true) {
      nextRow += dr[direction];
      nextCol += dc[direction];
      dist++;

      if (arr[nextRow][nextCol] == 'O') {
        break;
      }

      if (arr[nextRow][nextCol] == '#') {
        nextRow -= dr[direction];
        nextCol -= dc[direction];
        dist--;
        break;
      }
    }

    return new int[] {nextRow, nextCol, dist};
  }

  static class Node {
    int redRow;
    int redCol;
    int blueRow;
    int blueCol;
    int cnt;

    public Node(int redRow, int redCol, int blueRow, int blueCol, int cnt) {
      super();
      this.redRow = redRow;
      this.redCol = redCol;
      this.blueRow = blueRow;
      this.blueCol = blueCol;
      this.cnt = cnt;
    }
  }

}