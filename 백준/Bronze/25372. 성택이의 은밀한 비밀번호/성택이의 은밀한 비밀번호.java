import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(in.readLine());

    for (int i = 0; i < t; i++) {
      String input = in.readLine();

      if (input.length() >= 6 && input.length() <= 9) {
        sb.append("yes");
      } else {
        sb.append("no");

      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}