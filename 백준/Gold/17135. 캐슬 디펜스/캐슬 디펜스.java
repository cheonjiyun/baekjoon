
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

  static int N;
  static int M;
  static int D;

  static int[][] castle;

  static int[] pickedX = new int[3]; // i번째 궁수의 x 위치

  static int result = 0;

  // Exception 처리
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // 첫번째 라인 값 3 입력
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());

    castle = new int[N][M];

    // 두번째, 세번째, 네번째 라인 값 split 사용, 공백 기준으로 입력
    for (int i = 0; i < N; i++) {
      // StringTokenizer를 이용한 공백 기준으로 자르기
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        castle[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    pick(0, 0);

    bw.write(String.valueOf(result));

    br.close();

    // 최종 출력
    bw.flush();
    bw.close();
  }


  public static void pick(int count, int start) {
    // 한명씩 뽑아서 다 뽑으면 게임 돌려서 return 최대값을 답으로 넣기
    if (count == 3) {
      result = Math.max(result, game());
      return;
    }
    for (int cur = start; cur < M; cur++) {
      pickedX[count] = cur;
      pick(count + 1, cur + 1);
    }
  }

  private static int game() {
    int count = 0;
    int[][] status = new int[N][M];

    for (int liney = N; liney > 0; liney--) { // 밑에서부터 궁수가 올라옴
      for (int pick : pickedX) { // 궁수 위치
        int cnt = canAttack(status, liney, pick);
        if (cnt < 0)
          continue;
        else
          count += cnt;
      }
    }

    return count;
  }

  public static int canAttack(int[][] status, int liney, int pickX) {

    for (int d = 1; d <= D; d++) { // 궁수위치에서 공격 가능한 줄(y)
      for (int nx = pickX - d; nx <= pickX + d; nx++) { // 궁스위치에서 좌우로 공격 가능한 열(x)
        int ny = liney - (d - Math.abs(nx - pickX)); // x에서 이미 이동한 값을 빼고, 이동가능한 거리를 구한다. 지금 있는 곳에서
                                                     // 위로 갈 수 있는 y 거리. (유클리드)
        if (ny < 0 || ny >= liney || nx < 0 || nx >= M)
          continue;
        if (castle[ny][nx] == 0)
          continue;
        if (status[ny][nx] == 0) {
          status[ny][nx] = liney;
          return 1;
        } else if (status[ny][nx] == liney) // 다른라인에서 이미 지웠으면 자동으로 -1
          return 0;
      }
    }
    return -1;
  }
}