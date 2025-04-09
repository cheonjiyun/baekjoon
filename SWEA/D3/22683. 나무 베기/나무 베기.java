import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
  private static int[] dr = {-1, 0, 1, 0};
  private static int[] dc = {0, 1, 0, -1};

  private static int k;
  private static ArrayList<int[]> trees;
  private static char[][] arr;
  private static int n;

  private static int result;
  private static int[] start;

  public static void main(String[] args) throws Exception {


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int T = Integer.parseInt(st.nextToken());

    for (int test_case = 1; test_case <= T; test_case++) {
      result = Integer.MAX_VALUE;

      sb.append("#" + test_case + " ");

      st = new StringTokenizer(br.readLine().trim());
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());

      arr = new char[n][n];

      for (int i = 0; i < n; i++) {
        arr[i] = br.readLine().toCharArray();
      }

      start = new int[2];
      int[] end = new int[2];
      trees = new ArrayList<int[]>();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (arr[i][j] == 'X') {
            start[0] = i;
            start[1] = j;
          } else if (arr[i][j] == 'Y') {
            end[0] = i;
            end[1] = i;
          } else if (arr[i][j] == 'T') {
            trees.add(new int[] {i, j});
          }
        }
      }

      // 나무베기 -> 조합 (T개수 C k)

      // comb(0, 0, new boolean[trees.size()]);

      // 최소 조작 횟수 찾기
      sb.append(bfs()).append("\n");
    }

    System.out.println(sb);
  }

  public static boolean canMove(int row, int col, boolean[][] visited) {
    if (row >= 0 && row < n && col >= 0 && col < n
        && (arr[row][col] == 'G' || arr[row][col] == 'Y' || arr[row][col] == '.')
        && !visited[row][col]) {
      return true;
    } else {
      return false;
    }
  }

  public static int bfs() {
    Queue<Node> q = new PriorityQueue<Node>(new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {
        return o1.count - o2.count;
      }
    });
    q.add(new Node(start[0], start[1], 0, k, 0));

    boolean[][][][] visited = new boolean[n][n][k + 1][4];
    visited[start[0]][start[1]][k][0] = true;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (arr[cur.row][cur.col] == 'Y') {
        return cur.count;
      }

      // 직진

      for (int d = 0; d < 4; d++) {

        int nr = cur.row + dr[d];
        int nc = cur.col + dc[d];

        if (cur.direction == d) { // 같으면 직진
          if (nr < 0 || nr >= n || nc < 0 || nc >= n)
            continue;

          if (arr[nr][nc] == 'T') {
            // 나무를 만남
            if (cur.myK > 0) {
              // 나무 부실 수 있을 때만
              if (!visited[nr][nc][cur.myK - 1][d]) {
                visited[nr][nc][cur.myK - 1][d] = true;
                q.offer(new Node(nr, nc, d, cur.myK - 1, cur.count + 1));
              }
            }

          } else {
            if (!visited[nr][nc][cur.myK][d]) {
              visited[nr][nc][cur.myK][d] = true;
              q.offer(new Node(nr, nc, d, cur.myK, cur.count + 1));
            }
          }


        } else if ((cur.direction + 1) % 4 == d) {
          // 우회전
          if (!visited[cur.row][cur.col][cur.myK][d]) {
            visited[cur.row][cur.col][cur.myK][d] = true;
            q.offer(new Node(cur.row, cur.col, d, cur.myK, cur.count + 1));
          }

        } else if ((cur.direction - 1 + 4) % 4 == d) {
          // 좌회전
          if (!visited[cur.row][cur.col][cur.myK][d]) {
            visited[cur.row][cur.col][cur.myK][d] = true;
            q.offer(new Node(cur.row, cur.col, d, cur.myK, cur.count + 1));
          }
        }
      }

    }

    return -1;
  }

  public static class Node {
    int row;
    int col;
    int direction;
    int myK;
    int count;

    public Node(int row, int col, int direction, int myK, int count) {
      super();
      this.row = row;
      this.col = col;
      this.direction = direction;
      this.myK = myK;
      this.count = count;
    }

    @Override
    public String toString() {
      return "Node [row=" + row + ", col=" + col + ", direction=" + direction + ", myK=" + myK
          + ", count=" + count + "]";
    }


  }

  public static void comb(int cnt, int start, boolean selected[]) {
    if (cnt > k) {
      return;
    }

    for (int i = 0; i < trees.size(); i++) {
      if (selected[i] == true) {
        int[] tree = trees.get(i);
        int treeRow = tree[0];
        int treeCol = tree[1];

        arr[treeRow][treeCol] = '.';

      }
    }

    // 최소 이동거리
    bfs();

    // 원상복구
    for (int i = 0; i < trees.size(); i++) {
      if (selected[i] == true) {
        int[] tree = trees.get(i);
        int treeRow = tree[0];
        int treeCol = tree[1];

        arr[treeRow][treeCol] = 'T';

      }
    }

    for (int i = start; i < trees.size(); i++) {
      selected[i] = true;
      comb(cnt + 1, i + 1, selected);
      selected[i] = false;
    }
  }
}