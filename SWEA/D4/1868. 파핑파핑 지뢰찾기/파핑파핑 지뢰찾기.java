
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Solution {
  static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
  static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

  public static void main(String args[]) throws Exception {

    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {
      // 입력
      int n = sc.nextInt();
      String[][] landMine = new String[n][n];
      for (int i = 0; i < n; i++) {
        landMine[i] = sc.next().split("");
      }

      // 인접 지뢰 개수
      int[][] countLandMine = new int[n][n];
      List<XY> zeros = new ArrayList<>();
      List<XY> noZeros = new ArrayList<>();
      for (int y = 0; y < n; y++) {
        for (int x = 0; x < n; x++) {
          countLandMine[y][x] = getCountLandMine(landMine, x, y);
          if (countLandMine[y][x] == 0) {
            zeros.add(new XY(x, y));
          } else if (countLandMine[y][x] != -1) {
            noZeros.add(new XY(x, y));
          }
        }
      }

      boolean[][] visited = new boolean[n][n];
      int clickResult = 0;
      // 0 인곳부터 센다.
      for (XY zero : zeros) {
        if (visited[zero.y][zero.x] == false) {
          clickResult += 1;
          bfsIfZero(countLandMine, zero.x, zero.y, visited);
        }
      }
      // System.out.println("0끝--");
      for (XY noZero : noZeros) {
        if (visited[noZero.y][noZero.x] == false) {
          clickResult += 1;
        }
      }
      // 이제 0이 아닌 곳중 방문 안한 곳을 모두 합친다. && 지뢰가 아닌 곳
      // for (int y = 0; y < n; y++) {
      // for (int x = 0; x < n; x++) {
      // if (!landMine[y][x].equals("*") && countLandMine[y][x] != 0 && visited[y][x] == false) {
      // clickResult += 1;
      // }
      // }
      // }

      // for (int i = 0; i < n; i++) {
      // for (int j = 0; j < n; j++) {
      // System.out.print(visited[i][j]);
      // }
      // System.out.println();
      // }
      System.out.printf("#%d %d\n", test_case, clickResult);
    }
  }

  public static void bfsIfZero(int[][] countLandMine, int x, int y, boolean[][] visited) {

    // 방문함
    int n = countLandMine.length;

    Queue<XY> q = new LinkedList<>();
    q.add(new XY(x, y));
    visited[y][x] = true;
    while (q.size() > 0) {
      XY current = q.poll();

      for (int i = 0; i < 8; i++) {
        int nx = dx[i] + current.x;
        int ny = dy[i] + current.y;

        // 인접이 0이면 그 주변을 한번더, 그 지역을 방문안했을때만
        if (nx >= 0 && ny >= 0 && nx < n && ny < n && visited[ny][nx] == false
            && countLandMine[ny][nx] == 0) {

          visited[ny][nx] = true;
          q.add(new XY(nx, ny));
        }

        // 본인이 0인데 인접이 0이 아니면 방문만
        if (nx >= 0 && ny >= 0 && nx < n && ny < n && visited[ny][nx] == false
            && countLandMine[ny][nx] != 0 && countLandMine[current.y][current.x] == 0) {

          visited[ny][nx] = true;
        }
      }
    }

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

  public static int getCountLandMine(String[][] landMine, int x, int y) {

    int sumResult = 0;
    for (int i = 0; i < 8; i++) {
      int nx = dx[i] + x;
      int ny = dy[i] + y;

      if (nx >= 0 && ny >= 0 && nx < landMine.length && ny < landMine.length
          && landMine[ny][nx].equals("*")) {
        sumResult += 1;
      }
    }

    // -1은 본인이 지뢰
    if (landMine[y][x].equals("*")) {
      sumResult = -1;
    }
    return sumResult;
  }
}
