import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String[] input = in.readLine().split(" ");

    int x = Integer.parseInt(input[0]);
    int y = Integer.parseInt(input[1]);
    int w = Integer.parseInt(input[2]);
    int h = Integer.parseInt(input[3]);

    int wall = Math.min(Math.abs(x - w), Math.abs(y - h));
    int wall0 = Math.min(x - 0, y - 0);
    sb.append(Math.min(wall, wall0));


    System.out.println(sb);
  }
}