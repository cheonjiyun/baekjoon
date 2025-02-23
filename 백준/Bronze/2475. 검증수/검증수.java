import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String[] input = in.readLine().split(" ");

    int x1 = Integer.parseInt(input[0]);
    int x2 = Integer.parseInt(input[1]);
    int x3 = Integer.parseInt(input[2]);
    int x4 = Integer.parseInt(input[3]);
    int x5 = Integer.parseInt(input[4]);

    int result = (x1 * x1 + x2 * x2 + x3 * x3 + x4 * x4 + x5 * x5) % 10;


    System.out.println(result);
  }
}