import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static String[][] arr;
  static int n;

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    n = Integer.parseInt(st.nextToken());

    arr = new String[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = " ";
      }
    }

    divideConquer(n, 0, 0);
    print(sb);

    System.out.println(sb);
  }

  static void divideConquer(int size, int x, int y) {
    if (size == 3) {
      pull(x, y);
      return;
    }

    int sizeThree = size / 3;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1)
          continue;

        divideConquer(sizeThree, x + i * sizeThree, y + j * sizeThree);
      }
    }
    // divideConquer(sizeThree, x, y);
    // divideConquer(sizeThree, x + sizeThree, y);
    // divideConquer(sizeThree, x + sizeThree, y);
    // divideConquer(sizeThree, x + sizeThree + sizeThree, y);
    // divideConquer(sizeThree, x, y + sizeThree);
    // divideConquer(sizeThree, x, y + sizeThree + sizeThree);
    // divideConquer(sizeThree, x + sizeThree, y + sizeThree + sizeThree);
    // divideConquer(sizeThree, x + sizeThree + sizeThree, y + sizeThree + sizeThree);
    // divideConquer(sizeThree, x + sizeThree + sizeThree, y + sizeThree);
  }

  static void print(StringBuilder sb) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sb.append(arr[i][j]);
      }
      sb.append("\n");

    }
  }

  static public void pull(int x, int y) {
    for (int i = x; i < x + 3; i++) {
      for (int j = y; j < y + 3; j++) {
        if (i == x + 1 && j == y + 1)
          continue;

        arr[i][j] = "*";

      }
    }
  }
}