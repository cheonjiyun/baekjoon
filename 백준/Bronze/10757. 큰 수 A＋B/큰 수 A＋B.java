import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String[] input = in.readLine().split(" ");

    BigInteger a = new BigInteger(input[0]);
    BigInteger b = new BigInteger(input[1]);

    sb.append(a.add(b));



    System.out.println(sb);
  }
}