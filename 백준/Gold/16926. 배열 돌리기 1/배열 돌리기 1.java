import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());

    int[][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine().trim());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    while (r-- > 0) {
      for (int i = 0; i < Math.min(n, m) / 2; i++) { // 바깥에서 몇째줄이 회전중인지
        int temp = arr[i][i];

        // 윗
        for (int k = i; k < m - i - 1; k++) {
          arr[i][k] = arr[i][k + 1];
        }

        // 우
        for (int k = i; k < n - i - 1; k++) {
          arr[k][m - i - 1] = arr[k + 1][m - i - 1];
        }

        // 하
        for (int k = m - i - 1; k > i; k--) {
          arr[n - i - 1][k] = arr[n - i - 1][k - 1];
        }

        // 좌
        for (int k = n - i - 1; k > i; k--) {
          arr[k][i] = arr[k - 1][i];
        }

        arr[i + 1][i] = temp;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
}