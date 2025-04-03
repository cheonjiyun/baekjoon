import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  private static final int EMPTY = 0;
  private static final int SHARK = 9;

  private static int[] dr = {-1, 0, 1, 0};
  private static int[] dc = {0, -1, 0, 1};
  private static int n;

  private static RowCol sharkLocation;
  private static int sharkSize = 2;
  private static int sizeStack = 0;
  private static int[][] arr;

  private static int result;

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    n = Integer.parseInt(st.nextToken());

    arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine().trim());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());

        if (arr[i][j] == SHARK) {
          sharkLocation = new RowCol(i, j);
        }
      }
    }

    // 먹을 수 있는 물고기가 있는지 확인
    // bfs로 - 위 - 왼쪽 순으로
    // 같거나 경우 통과 가능
    // 작은 물고기 발견 시 먹기
    // 시간 추가
    // 자신의 크기와 같음 물고기를 먹을 때 크기 +1
    // continue 반복
    // 더이상 갈 곳이 없으면 끝

    while (bfs(sharkLocation)) {
      // for (int i = 0; i < n; i++) {
      // for (int j = 0; j < n; j++) {
      // System.out.print(arr[i][j]);
      // }
      // System.out.println();
      // }
      // System.out.printf("(%d / %d) \n", sizeStack, sharkSize);
      //
      // System.out.println();
    }


    sb.append(result);



    System.out.println(sb);
  }

  public static boolean bfs(RowCol start) {
    // 잡을 물고기 찾기
    Queue<RowCol> q = new ArrayDeque<>();
    q.offer(new RowCol(start.row, start.col));

    boolean[][] visited = new boolean[n][n];
    visited[start.row][start.col] = true;

    int time = -1;
    List<RowCol> answer = new ArrayList<>();

    while (!q.isEmpty() && answer.isEmpty()) {
      time++;
      int size = q.size();

      for (int i = 0; i < size; i++) {
        // System.out.println(q);
        RowCol cur = q.poll();


        if (arr[cur.row][cur.col] != EMPTY && arr[cur.row][cur.col] != SHARK
            && arr[cur.row][cur.col] < sharkSize) {
          // 정답 있어요
          answer.add(cur);

          continue;
        }

        for (int d = 0; d < 4; d++) {
          int nrow = cur.row + dr[d];
          int ncol = cur.col + dc[d];

          if (nrow < 0 || nrow >= n || ncol < 0 || ncol >= n || visited[nrow][ncol])
            continue;

          if (arr[nrow][ncol] <= sharkSize) {
            q.offer(new RowCol(nrow, ncol));
            visited[nrow][ncol] = true;
          }

        }
      }
    }


    Collections.sort(answer, new Comparator<RowCol>() {

      @Override
      public int compare(RowCol o1, RowCol o2) {
        if (o1.row == o2.row) {
          return o1.col - o2.col;
        }
        return o1.row - o2.row;
      }

    });

    // 여러개면 찾기
    if (!answer.isEmpty()) {

      RowCol min = answer.get(0);

      // 정답
      result += time;

      // 상어이동
      arr[sharkLocation.row][sharkLocation.col] = EMPTY;

      // 먹고 이동
      sharkLocation.row = min.row;
      sharkLocation.col = min.col;

      arr[sharkLocation.row][sharkLocation.col] = SHARK;


      // 크기가 커지면
      sizeStack++;
      if (sizeStack == sharkSize) {
        sharkSize++; // 상어 몸집은 커지고
        sizeStack = 0; // 초기화
      }
    }

    // for (int i = 0; i < n; i++) {
    // for (int j = 0; j < n; j++) {
    // System.out.print(visited[i][j]);
    // }
    // System.out.println();
    // }
    // System.out.println();

    return !answer.isEmpty();
  }

  public static class RowCol {
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

}