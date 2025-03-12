import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] dCol = {1, 1, 1};
  static int[] dRow = {-1, 0, 1};
  static char[][] ground;

  static int c;
  static int r;

  static int result = 0;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    ground = new char[r][c];
    for (int i = 0; i < r; i++) {
      st = new StringTokenizer(br.readLine().trim());
      char[] input = st.nextToken().toCharArray();
      for (int j = 0; j < c; j++) {
        ground[i][j] = input[j];
      }

    }


    for (int i = 0; i < r; i++) {
      result += dfs(0, i);
    }

    sb.append(result);
    System.out.println(sb);
  }

  static int dfs(int col, int row) {


    ground[row][col] = '-';

    for (int i = 0; i < 3; i++) {
      int nCol = dCol[i] + col;
      int nRow = dRow[i] + row;

      if (nCol == c) {
        return 1;
      }

      if (isWall(nCol, nRow))
        continue;

      if (ground[nRow][nCol] == '.') {
        // 방문
        if (dfs(nCol, nRow) == 1) {
          return 1;
        } ;
      }

    }
    return 0;
  }

  static boolean isWall(int col, int row) {
    if (col < 0 || row < 0 || col >= c || row >= r)
      return true;
    else
      return false;
  }
}