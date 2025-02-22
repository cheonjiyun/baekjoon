import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(in.readLine());

    for (int i = 1; i <= t; i++) {
      sb.append(i);
      sb.append("\n");
    }

    System.out.println(sb);
  }
}