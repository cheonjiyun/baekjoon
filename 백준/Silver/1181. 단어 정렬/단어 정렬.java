
// JAVA IO import
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

  // Exception 처리
  public static void main(String[] args) throws Exception {

    // BufferedReader 선언
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter 선언
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // 첫번째 라인 값 3 입력
    int T = Integer.parseInt(br.readLine());

    String[] arr = new String[T];

    // 두번째, 세번째, 네번째 라인 값 split 사용, 공백 기준으로 입력
    for (int te = 0; te < T; te++) {
      // StringTokenizer를 이용한 공백 기준으로 자르기
      arr[te] = (br.readLine());
    }

    Arrays.sort(arr, new Comparator<String>() {

      @Override
      public int compare(String o1, String o2) {
        // TODO Auto-generated method stub
        if (o1.length() == o2.length()) {
          return o1.compareTo(o2);
        } else {
          return o1.length() - o2.length();
        }
      }

    });

    for (int i = 0; i < T; i++) {
      if (i - 1 >= 0 && arr[i - 1].equals(arr[i])) {
        continue;
      }
      System.out.println(arr[i]);
    }
    br.close();

    // 최종 출력
    bw.flush();
    bw.close();
  }
}
