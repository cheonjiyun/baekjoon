import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] n = br.readLine().split("");
    Arrays.sort(n, Collections.reverseOrder());

    bw.write(String.valueOf(String.join("", n)));
    bw.flush();
    bw.close();
  }

}
