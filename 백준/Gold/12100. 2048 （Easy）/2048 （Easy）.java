import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, 1, 0, -1};

  static final int UP = 0;
  static final int RIGHT = 1;
  static final int DOWN = 2;
  static final int LEFT = 3;
  static final int EMPTY = 0;

  static int result = 0;

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int n = Integer.parseInt(st.nextToken());

    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine().trim());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        if (result < arr[i][j]) {
          result = arr[i][j];
        }
      }
    }

    // 위로 이동시
    /**
     * 위로 이동시 2행부터 위에 숫자가 있는지 for문 i행 ~ 0행 큰 숫자를 만나면 그 전으로 이동 같은 숫자를 만나면 합치고 현재 위치 0으로
     * 
     */


    // 이동
    // 좌우상하
    // 5번

    bfs(0, arr);


    sb.append(result);
    System.out.println(sb);

  }

  public static void bfs(int cnt, int[][] newArr) {
    if (cnt == 5) {
      return;
    }

    for (int i = 0; i < 4; i++) {
      bfs(cnt + 1, move(i, newArr));
    }
  }

  public static void print(int[][] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {

        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static int[][] move(int direction, int[][] arr) {

    int n = arr.length;

    int[][] newArr = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        newArr[i][j] = arr[i][j];
      }
    }

    boolean[][] combined = new boolean[n][n];

    if (direction == UP) {
      for (int row = 1; row < n; row++) {
        coloop: for (int col = 0; col < n; col++) {
          if (newArr[row][col] == EMPTY)
            continue;

          // check
          for (int i = row; i > 0; i--) {

            // 같으면
            if (newArr[i - 1][col] == newArr[row][col]) {

              if (combined[i - 1][col]) {
                // 현재로 이동
                int value = newArr[row][col];
                newArr[row][col] = EMPTY;
                newArr[i][col] = value;
              } else {
                // 합친다.

                newArr[i - 1][col] += newArr[row][col];
                newArr[row][col] = EMPTY;

                combined[i - 1][col] = true;
                // 최댓값
                result = Math.max(result, newArr[i - 1][col]);
              }



              continue coloop;
            }
            // 현재가 위에가 더 크거나 작으면
            else if (newArr[i - 1][col] != newArr[row][col] && newArr[i - 1][col] != EMPTY) {
              // 현재로 이동
              int value = newArr[row][col];
              newArr[row][col] = EMPTY;
              newArr[i][col] = value;
              continue coloop;
            }
          }

          int value = newArr[row][col];
          newArr[row][col] = EMPTY;
          newArr[0][col] = value;

        }
      }
    } else if (direction == RIGHT) {
      for (int col = n - 2; col >= 0; col--) {
        coloop: for (int row = 0; row < n; row++) {
          if (newArr[row][col] == EMPTY)
            continue;

          // check
          for (int j = col; j < n - 1; j++) {

            // 같으면
            if (newArr[row][j + 1] == newArr[row][col]) {
              if (combined[row][j + 1]) {

                int value = newArr[row][col];
                newArr[row][col] = EMPTY;
                newArr[row][j] = value;
              } else {

                // 합친다.
                newArr[row][j + 1] += newArr[row][col];
                newArr[row][col] = EMPTY;

                combined[row][j + 1] = true;
                result = Math.max(result, newArr[row][j + 1]);
              }
              continue coloop;
            }
            // 현재가 위에가 더 크거나 작으면
            else if (newArr[row][j + 1] != newArr[row][col] && newArr[row][j + 1] != EMPTY) {
              // 현재로 이동
              int value = newArr[row][col];
              newArr[row][col] = EMPTY;
              newArr[row][j] = value;
              continue coloop;
            }
          }


          int value = newArr[row][col];
          newArr[row][col] = EMPTY;
          newArr[row][n - 1] = value;
        }
      }
    } else if (direction == DOWN) {
      for (int row = n - 2; row >= 0; row--) {
        coloop: for (int col = 0; col < n; col++) {
          if (newArr[row][col] == EMPTY)
            continue;

          // check
          for (int i = row; i < n - 1; i++) {


            // 같으면
            if (newArr[i + 1][col] == newArr[row][col]) {
              if (combined[i + 1][col]) {

                int value = newArr[row][col];
                newArr[row][col] = EMPTY;
                newArr[i][col] = value;

              } else {

                // 합친다.
                newArr[i + 1][col] += newArr[row][col];
                newArr[row][col] = EMPTY;

                combined[i + 1][col] = true;
                result = Math.max(result, newArr[i + 1][col]);
              }
              continue coloop;
            }
            // 현재가 위에가 더 크거나 작으면
            else if (newArr[i + 1][col] != newArr[row][col] && newArr[i + 1][col] != EMPTY) {
              // 현재로 이동
              int value = newArr[row][col];
              newArr[row][col] = EMPTY;
              newArr[i][col] = value;
              continue coloop;
            }
          }


          int value = newArr[row][col];
          newArr[row][col] = EMPTY;
          newArr[n - 1][col] = value;


        }
      }
    } else if (direction == LEFT) {
      for (int col = 1; col < n; col++) {
        coloop: for (int row = 0; row < n; row++) {
          if (newArr[row][col] == EMPTY)
            continue;

          // check
          for (int j = col; j > 0; j--) {
            // 같으면
            if (newArr[row][j - 1] == newArr[row][col]) {

              if (combined[row][j - 1]) {
                int value = newArr[row][col];
                newArr[row][col] = EMPTY;
                newArr[row][j] = value;

              } else {
                // 합친다.
                newArr[row][j - 1] += newArr[row][col];
                newArr[row][col] = EMPTY;

                combined[row][j - 1] = true;
                result = Math.max(result, newArr[row][j - 1]);


              }
              continue coloop;
            }
            // 현재가 위에가 더 크거나 작으면
            else if (newArr[row][j - 1] != newArr[row][col] && newArr[row][j - 1] != EMPTY) {

              // 현재로 이동

              int value = newArr[row][col];
              newArr[row][col] = EMPTY;
              newArr[row][j] = value;
              continue coloop;
            }
          }


          int value = newArr[row][col];
          newArr[row][col] = EMPTY;
          newArr[row][0] = value;

        }
      }
    }


    return newArr;
  }


}