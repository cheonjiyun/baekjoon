
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
    int T = Integer.parseInt(br.readLine());

    // 두번째, 세번째, 네번째 라인 값 split 사용, 공백 기준으로 입력
    for (int te = 0; te < T; te++) {
      // StringTokenizer를 이용한 공백 기준으로 자르기
      String st = br.readLine();

      bw.write(st.substring(0, 1) + st.substring(st.length() - 1) + "\n");
    }
    br.close();

    // 최종 출력
    bw.flush();
    bw.close();
  }
}
