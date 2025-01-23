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

    // 맨 아랫변 + 왼쪽면 + 오른쪽면 + 게단층에 있는 절반영역 => 4n
    BigInteger result = n.multiply(new BigInteger("4"));
    bw.write(String.valueOf(result));

    bw.flush();
    bw.close();
  }
}
