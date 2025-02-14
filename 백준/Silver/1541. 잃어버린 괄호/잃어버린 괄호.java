import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
  // Exception 처리
  public static void main(String[] args) throws Exception {

    // BufferedReader 선언
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter 선언
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // 첫번째 라인 값 3 입력
    String s = br.readLine();

    String[] nums = s.split("-");

    List<Integer> finalNum = new ArrayList<>();
    for (String num : nums) {
      int tempSum = 0;
      for (String numb : num.split("\\+")) {
        tempSum += Integer.valueOf(numb);
      }
      finalNum.add(tempSum);
    }

    int result = finalNum.get(0);
    for (int i = 1; i < finalNum.size(); i++) {
      result -= finalNum.get(i);
    }
    bw.write(String.valueOf(result));

    br.close();

    // 최종 출력
    bw.flush();
    bw.close();
  }
}
