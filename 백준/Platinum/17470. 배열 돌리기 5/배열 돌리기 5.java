
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private static int n;
  private static int m;
  private static int r;
  private static int[][] arr;
  private static int[][] comArr;

  private static boolean verticalReversal = false;//
  private static boolean horizotalReversal = false;//
  static int rotateState = 0; // 0도 , 90도, 180도, 270도
  private static int[][] newArr;

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    arr = new int[n][m];
    newArr = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine().trim());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    comArr = new int[][] {{0, 1}, {2, 3}};

    st = new StringTokenizer(br.readLine().trim());
    int[] commands = new int[r];
    for (int i = 0; i < r; i++) {
      commands[i] = Integer.parseInt(st.nextToken());
    }

    // 명령어 수행
    for (int c = 0; c < r; c++) {
      int command = commands[c];
      if (command == 1) {
        // 상하방전
        command1();
      } else if (command == 2) {
        // 좌우반전
        command2();
      } else if (command == 3) {
        // 오른쪽 90도 회전
        command3();
      } else if (command == 4) {

        // 왼쪽 90도 회전
        command4();
      } else if (command == 5) {

        // 1/4 오른쪽 90도 회전
        command5();
      } else if (command == 6) {

        // 1/4 왼쪽 90도 회전
        command6();
      }
    }


    // -----------------------------------------
    // 압축배열로 본 배열 만들기
    // 4등분 해서 넣기
    int rowHalf = n / 2;
    int colHalf = m / 2;
    for (int number = 0; number < 4; number++) {
      // 0, 1, 2, 3 숫자를 배열 중에 찾기
      for (int row = 0; row < 2; row++) {
        for (int col = 0; col < 2; col++) {

          if (comArr[row][col] == number) {
            // 새로운 배열 위치
            int startRowByNewArr = rowHalf * row; // row가 0이면 0 1이면 half
            int distRowByNewArr = rowHalf + (rowHalf * row); // row가 0이면 half, 1이면 n
            int startColByNewArr = colHalf * col;
            int distColByNewArr = colHalf + (colHalf * col);

            // 본래 배열 위치
            int startRow = 0;
            int startCol = 0;

            if (comArr[row][col] == 0) {
              startRow = 0;
              startCol = 0;
            } else if (comArr[row][col] == 1) {

              startRow = 0;
              startCol = colHalf;
            } else if (comArr[row][col] == 2) {

              startRow = rowHalf;
              startCol = 0;
            } else if (comArr[row][col] == 3) {
              startRow = rowHalf;
              startCol = colHalf;
            }


            if (verticalReversal == false && horizotalReversal == false) {
              // 그대로 채우기
              for (int i = 0; i < rowHalf; i++) {
                for (int j = 0; j < colHalf; j++) {
                  newArr[startRowByNewArr + i][startColByNewArr + j] =
                      arr[startRow + i][startCol + j];
                }
              }
            }
            if (verticalReversal == true && horizotalReversal == false) {
              // 수직 반전
              // 아래서부터 채움
              for (int i = 0; i < rowHalf; i++) {
                for (int j = 0; j < colHalf; j++) {
                  newArr[distRowByNewArr - 1 - i][startColByNewArr + j] =
                      arr[startRow + i][startCol + j];
                }
              }
            }
            if (verticalReversal == false && horizotalReversal == true) {
              // 좌우 반전
              // 오른쪽
              for (int i = 0; i < rowHalf; i++) {
                for (int j = 0; j < colHalf; j++) {
                  newArr[startRowByNewArr + i][distColByNewArr - 1 - j] =
                      arr[startRow + i][startCol + j];
                }
              }
            }
            if (verticalReversal == true && horizotalReversal == true) {
              // 좌우 반전 + 상하반전
              // 오른쪽 아래부터 채움 거꾸로
              for (int i = 0; i < rowHalf; i++) {
                for (int j = 0; j < colHalf; j++) {
                  newArr[distRowByNewArr - 1 - i][distColByNewArr - 1 - j] =
                      arr[startRow + i][startCol + j];
                }
              }
            }
          }
        }
      }
    }
    // --------------압축배열 본 배열로 넣기 끝---------------

    // --------------- 회전여부에 따른 카메라 회전 출력----------------------
    if (rotateState == 0) {
      // 그대로 출력
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          System.out.print(newArr[i][j] + " ");
        }
        System.out.println();
      }
      System.out.println();
    } else if (rotateState == 1) {
      for (int j = 0; j < m; j++) {
        for (int i = n - 1; i >= 0; i--) {
          System.out.print(newArr[i][j] + " ");
        }
        System.out.println();
      }
      System.out.println();
    } else if (rotateState == 2) {
      for (int i = n - 1; i >= 0; i--) {
        for (int j = m - 1; j >= 0; j--) {
          System.out.print(newArr[i][j] + " ");
        }
        System.out.println();
      }
      System.out.println();
    } else if (rotateState == 3) {
      for (int j = m - 1; j >= 0; j--) {
        for (int i = 0; i < n; i++) {
          System.out.print(newArr[i][j] + " ");
        }
        System.out.println();
      }
      System.out.println();
    }


    // -------------------------------------------

    System.out.println(sb);
  }

  public static void command1() {

    if (rotateState == 0 || rotateState == 2) {
      verticalReversal = !verticalReversal;

      // 왼쪽 상하
      int temp = comArr[0][0];
      comArr[0][0] = comArr[1][0];
      comArr[1][0] = temp;

      // 오른쪽 상하
      temp = comArr[0][1];
      comArr[0][1] = comArr[1][1];
      comArr[1][1] = temp;
    } else if (rotateState == 1 || rotateState == 3) {
      horizotalReversal = !horizotalReversal;

      // 90도 180도라면 고개를 90도로 돌려

      int temp = comArr[0][0];
      comArr[0][0] = comArr[0][1];
      comArr[0][1] = temp;

      temp = comArr[1][0];
      comArr[1][0] = comArr[1][1];
      comArr[1][1] = temp;
    }
  }

  public static void command2() {
    // 좌우반전
    if (rotateState == 0 || rotateState == 2) {
      horizotalReversal = !horizotalReversal;
      int temp = comArr[0][0];
      comArr[0][0] = comArr[0][1];
      comArr[0][1] = temp;

      temp = comArr[1][0];
      comArr[1][0] = comArr[1][1];
      comArr[1][1] = temp;

    } else if (rotateState == 1 || rotateState == 3) {
      verticalReversal = !verticalReversal;
      int temp = comArr[0][0];
      comArr[0][0] = comArr[1][0];
      comArr[1][0] = temp;

      // 오른쪽 상하
      temp = comArr[0][1];
      comArr[0][1] = comArr[1][1];
      comArr[1][1] = temp;

    }
  }

  public static void command3() {
    // 오른쪽으로 90도 회전
    rotateState = (rotateState + 4 + 1) % 4;
  }

  private static void command4() {
    // 왼쪽으로 90도 회전
    rotateState = (rotateState + 4 - 1) % 4;
  }

  private static void command5() {
    int temp = comArr[0][0];
    comArr[0][0] = comArr[1][0];
    comArr[1][0] = comArr[1][1];
    comArr[1][1] = comArr[0][1];
    comArr[0][1] = temp;
  }

  private static void command6() {
    int temp = comArr[0][0];
    comArr[0][0] = comArr[0][1];
    comArr[0][1] = comArr[1][1];
    comArr[1][1] = comArr[1][0];
    comArr[1][0] = temp;
  }

}
