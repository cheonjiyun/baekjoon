
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int len = Integer.parseInt(in.readLine());

    // 정삼각형
    // L^2 - (1/5) *(L^2)
    // = 3/4 * (L^2)
    // = sqrt(3/4*L^2)

    // 넓이
    // sqrt(3/4*L^2) * 1/2*L
    // sqrt(3) / 4 * L^2

    double result = Math.sqrt(3) / 4 * Math.pow(len, 2);
    sb.append(result);
    System.out.println(sb);
  }
}
