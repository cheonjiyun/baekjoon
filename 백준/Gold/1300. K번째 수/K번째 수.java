import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

  static int[] b;

  public static int findBiggerIndex(int num) {
    int result = -1; // 나보다 큰 애가 없어
    for (int i = 0; i < b.length; i++) {
      if (b[i] == 0) {
        result = i; // 0이면 아직 초기화 상태
        break;
      }

      if (b[i] > num) {
        result = i;
        break;
      }
    }
    return result;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(in.readLine());
    int k = Integer.parseInt(in.readLine());

    long low = 1;
    long high = k;

    while (low < high) {
      long mid = (low + high) / 2;
      long count = 0;

      for (int i = 1; i <= n; i++) {
        count += Math.min(mid / i, n);
      }

      if (k <= count) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    sb.append(low);
    System.out.println(sb);
  }
}