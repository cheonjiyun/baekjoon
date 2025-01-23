
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

  public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    BigInteger n = new BigInteger(br.readLine());
    br.close();


    BigInteger result1 = n.multiply(new BigInteger(String.valueOf(n.intValue() - 1)));
    bw.write(String.valueOf(result1.divide(new BigInteger("2"))) + "\n");
    bw.write(String.valueOf(2));

    bw.flush();
    bw.close();
  }
}
