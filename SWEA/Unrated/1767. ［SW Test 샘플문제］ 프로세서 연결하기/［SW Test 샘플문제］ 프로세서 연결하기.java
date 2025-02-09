
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Solution {

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {-1, 0, 1, 0};

  static int resultCount = 0;
  static int resultCore = 0;

  public static void main(String args[]) throws Exception {

    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {
      // 초기화
      resultCount = 0;
      resultCore = 0;

      // 입력
      int n = sc.nextInt();
      int[][] maxnos = new int[n][n];

      List<XY> cores = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          maxnos[i][j] = sc.nextInt();
          if (maxnos[i][j] == 1 && i != 0 && j != 0 && i != n - 1 && j != n - 1) { // 가장자리에 있으면
                                                                                   // 저장안해서 시간줄이기-!
            cores.add(new XY(j, i));
          }
        }
      }

      dfs(maxnos, cores, 0, 0, 0);

      System.out.printf("#%d %d\n", test_case, resultCount);

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

  public static void dfs(int[][] maxnos, List<XY> cores, int idx, int beforeCoreCount,
      int beforefrontCount) {

    // 새 배열
    int n = maxnos.length;


    if (idx == cores.size()) {
      if (resultCore < beforeCoreCount) {
        resultCore = beforeCoreCount;
        resultCount = beforefrontCount;
      } else if (resultCore == beforeCoreCount) {
        resultCount = Math.min(resultCount, beforefrontCount);
      }


      // for (int i = 0; i < n; i++) {
      // for (int j = 0; j < n; j++) {
      // System.out.print(maxnos[i][j]);
      // }
      // System.out.println();
      // }

      return;
    }


    // 4방향
    for (int direction = 0; direction < 4; direction++) {
      // int[][] newMaxnos = new int[n][n];
      // for (int i = 0; i < n; i++) {
      // for (int j = 0; j < n; j++) {
      // newMaxnos[i][j] = maxnos[i][j];
      // }
      // }

      int nx = cores.get(idx).x + dx[direction];
      int ny = cores.get(idx).y + dy[direction];

      int frontCount = 0;
      // 마지막 혹은 core 혹은 다른 전선을 만날 때 까지 일자로 감
      while (nx >= 0 && ny >= 0 && nx < n && ny < n) {
        if (maxnos[ny][nx] == 2 || maxnos[ny][nx] == 1) {
          frontCount = 0;
          break;
        }
        frontCount += 1;

        nx += dx[direction];
        ny += dy[direction];
      }

      // 먼저 가능한지 검사하고 채우기
      int fillx = cores.get(idx).x + dx[direction];
      int filly = cores.get(idx).y + dy[direction];
      for (int i = 0; i < frontCount; i++) {
        maxnos[filly][fillx] = 2;
        fillx += dx[direction];
        filly += dy[direction];
      }


      // 다음 core
      if (frontCount != 0) {
        dfs(maxnos, cores, idx + 1, beforeCoreCount + 1, beforefrontCount + frontCount);

        // 되돌리기
        fillx = cores.get(idx).x + dx[direction];
        filly = cores.get(idx).y + dy[direction];
        for (int i = 0; i < frontCount; i++) {
          maxnos[filly][fillx] = 0;
          fillx += dx[direction];
          filly += dy[direction];
        }

      } else {
        dfs(maxnos, cores, idx + 1, beforeCoreCount, beforefrontCount);
      }
    }

  }
}
