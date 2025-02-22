import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String input1 = in.readLine();
    String input2 = in.readLine();

    if (input1.length() >= input2.length()) {
      sb.append("go");
    } else {
      sb.append("no");
    }
    System.out.println(sb);
  }


}