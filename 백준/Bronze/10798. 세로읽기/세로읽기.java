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


    String[][] arr = new String[15][15];

    for (int t = 0; t < 5; t++) {
      String str = br.readLine();
      // System.out.println(str);
      String[] sp = str.split("");
      for (int i = 0; i < sp.length; i++) {
        arr[t][i] = sp[i];
      }
      // yidx++;
    }

    for (int x = 0; x < 15; x++) {
      for (int y = 0; y < 15; y++) {
        if (arr[y][x] != null) {

          System.out.print(arr[y][x]);
        }
      }
    }
    // 두번째, 세번째, 네번째 라인 값 split 사용, 공백 기준으로 입력

    br.close();

    // 최종 출력
    bw.flush();
    bw.close();
  }
}
