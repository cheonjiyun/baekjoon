import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

  static int r;
  static int c;
  static String[][] ground;
  static String PIPE = "P";

  public static boolean dfs(int x, int y) {
    if (x == c - 1) {
      return true;
    }

    int nx = x + 1;
    for (int ny = y - 1; ny <= y + 1; ny++) {
      // 오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선
      if (ny < 0 || ny >= r)
        continue; // 벗어남
      if (ground[ny][nx].equals("x"))
        continue; // 벽
      if (ground[ny][nx].equals(PIPE))
        continue; // 파이프

      ground[ny][nx] = PIPE;
      if (dfs(nx, ny))
        return true;
      // ground[ny][nx] = ".";
    }
    return false;
  }

  public static void main(String[] args) throws Exception {

    /*
     * 0. 입력파일 읽어들이기
     */
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    // 결과를 한 번에 출력하기 위한 StringBuilder
    StringBuilder sb = new StringBuilder();

    // 여러분의 알고리즘 코드 작성하기

    /*
     * 1. 입력 파일 객체화
     */

    String[] inputs = in.readLine().split(" ");
    r = Integer.parseInt(inputs[0]);
    c = Integer.parseInt(inputs[1]);

    ground = new String[r][c];
    for (int i = 0; i < r; i++) {
      String[] input = in.readLine().split("");
      for (int j = 0; j < c; j++) {
        ground[i][j] = input[j];
      }
    }

    /*
     * 2. 알고리즘 풀기
     */


    int result = 0;
    for (int y = 0; y < r; y++) {
      ground[y][0] = "P";
      if (dfs(0, y))
        result += 1;
    }


    /*
     * 정답 출력
     */

    sb.append(result);
    System.out.println(sb);
  }
}