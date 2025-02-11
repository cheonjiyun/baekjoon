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
    int t = Integer.valueOf(br.readLine());

    for (int i = 0; i < t; i++) {
      String[] ab = br.readLine().split(",");
      int a = Integer.valueOf(ab[0]);
      int b = Integer.valueOf(ab[1]);
      bw.write(String.valueOf(a + b) + "\n");

    }


    br.close();

    // 최종 출력
    bw.flush();
    bw.close();
  }
}
