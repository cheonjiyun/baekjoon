import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private static int[][] arr;

  static int[] dx = {0, 1, -1, 0, 0};
  static int[] dy = {0, 0, 0, -1, 1};

  private static int floor;

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine().trim());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int current = 0;
    int left = 0;
    int right = 0;
    int up = 0;
    int down = 0;
    floor = 0;

    st = new StringTokenizer(br.readLine().trim());
    for (int c = 0; c < k; c++) {
      int command = Integer.parseInt(st.nextToken());

      int nextX = x + dx[command];
      int nextY = y + dy[command];

      if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n)
        continue;

      if (command == 1) {
        // 주사위 이동
        int tempRight = right;
        right = current;
        current = left;
        left = floor;
        floor = tempRight;

      } else if (command == 2) {

        int tempLeft = left;
        left = current;
        current = right;
        right = floor;
        floor = tempLeft;

      } else if (command == 3) {

        int tempUp = up;
        up = current;
        current = down;
        down = floor;
        floor = tempUp;


      } else if (command == 4) {

        int tempFloor = floor;

        floor = down;
        down = current;
        current = up;
        up = tempFloor;

      }


      x = nextX;
      y = nextY;

      infection(x, y);
      // System.out.println(" " + up + " ");
      // System.out.println(left + " " + current + " " + right);
      // System.out.println(" " + down + " ");
      // System.out.println(" " + floor + " ");
      // System.out.println();

      sb.append(current).append("\n");
    }

    System.out.println(sb);
  }


  private static void infection(int x, int y) {
    // 주사위 값 옮기기
    if (arr[y][x] == 0) {
      arr[y][x] = floor;
    } else {
      floor = arr[y][x];
      arr[y][x] = 0;
    }
  }
}