// JAVA IO import
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  // Exception 처리
  public static void main(String[] args) throws Exception {

    // BufferedReader 선언
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter 선언
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // 첫번째 라인 값 3 입력
    String s = br.readLine();

    StringBuffer sb = new StringBuffer(s);
    String resb = sb.reverse().toString();

    bw.write(String.valueOf(s.equals(resb) ? 1 : 0));


    br.close();

    // 최종 출력
    bw.flush();
    bw.close();
  }
}
