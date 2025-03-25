import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  static final int FLOOR = 0;
  static final int APPLE = 1;
  static final int SNAKE = 2;
  static int[][] board;

  static int[] dc = {1, 0, -1, 0};
  static int[] dr = {0, 1, 0, -1};

  static int RIGHT = 1;
  static int LEFT = -1;

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int n = Integer.parseInt(st.nextToken());

    board = new int[n + 1][n + 1];

    st = new StringTokenizer(br.readLine().trim());
    int k = Integer.parseInt(st.nextToken());

    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine().trim());

      int row = Integer.parseInt(st.nextToken());
      int col = Integer.parseInt(st.nextToken());

      board[row][col] = APPLE;
    }

    st = new StringTokenizer(br.readLine().trim());
    int l = Integer.parseInt(st.nextToken());

    Deque<Rotate> rotates = new LinkedList<>();
    for (int i = 0; i < l; i++) {
      st = new StringTokenizer(br.readLine().trim());
      int x = Integer.parseInt(st.nextToken());
      int direction = st.nextToken().equals("D") ? 1 : -1;

      rotates.offerLast(new Rotate(x, direction));
    }


    Deque<RowCol> snakeLocation = new LinkedList<>();
    snakeLocation.offer(new RowCol(1, 1));
    board[1][1] = SNAKE;

    int time = 0;
    int currentDirection = 0;

    while (true) {

      time++;

      // // 상태출력
      // for (int i = 0; i < n + 1; i++) {
      // for (int j = 0; j < n + 1; j++) {
      // System.out.print(board[i][j]);
      // }
      // System.out.println();
      // }
      // System.out.println();
      // System.out.println(snakeLocation);

      // 다음 머리
      RowCol head = snakeLocation.peekFirst();

      int nextRow = head.row + dr[currentDirection];
      int nextCol = head.col + dc[currentDirection];

      // 닿았으므로 게임 끝
      if (nextRow < 1 || nextCol < 1 || nextRow > n || nextCol > n
          || board[nextRow][nextCol] == SNAKE) {
        break;
      }

      // 사과면 먹기
      if (board[nextRow][nextCol] == APPLE) {
        board[nextRow][nextCol] = FLOOR;
      } // 그자리가 사과가 아니면 꼬리 줄이기
      else {
        RowCol pollLast = snakeLocation.pollLast();
        board[pollLast.row][pollLast.col] = FLOOR;
      }

      // 머리 늘리기
      board[nextRow][nextCol] = SNAKE;
      snakeLocation.offerFirst(new RowCol(nextRow, nextCol));

      // 지금 초가 방향이 바뀌어야한다면 바꾸기
      if (!rotates.isEmpty() && rotates.peek().time == time) {
        Rotate ro = rotates.pollFirst();
        currentDirection = (currentDirection + ro.direction + 4) % 4;
      }



    }



    sb.append(time);

    System.out.println(sb);
  }

  static class RowCol {
    int row;
    int col;

    public RowCol(int row, int col) {
      super();
      this.row = row;
      this.col = col;
    }

    @Override
    public String toString() {
      return "RowCol [row=" + row + ", col=" + col + "]";
    }


  }

  static class Rotate {
    int time;
    int direction;

    public Rotate(int time, int direction) {
      super();
      this.time = time;
      this.direction = direction;
    }

    @Override
    public String toString() {
      return "Rotate [time=" + time + ", direction=" + direction + "]";
    }


  }
}