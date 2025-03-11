import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static String[][] arr;

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int n = Integer.parseInt(st.nextToken());

    arr = new String[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine().trim());
      String[] input = st.nextToken().split("");

      for (int j = 0; j < n; j++) {
        arr[i][j] = input[j];
      }
    }

    String result = divideConquer(n, 0, 0);
    sb.append(result);
    System.out.println(sb);
  }

  static String divideConquer(int size, int x, int y) {
    if (size == 1) {
      // System.out.println("x y " + x + " " + y + " " + arr[y][x]);

      return arr[y][x];
    }

    int half = size / 2;

    String sum = "";
    sum += divideConquer(half, x, y);
    sum += divideConquer(half, x + half, y);
    sum += divideConquer(half, x, y + half);
    sum += divideConquer(half, x + half, y + half);

    if (sum.equals("0000")) {
      return "0";
    } else if (sum.equals("1111")) {
      return "1";
    } else {
      return "(" + sum + ")";
    }

  }
}