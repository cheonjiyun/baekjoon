import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
  // Exception 처리
  public static void main(String[] args) throws Exception {

    // BufferedReader 선언
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter 선언
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // 첫번째 라인 값 3 입력
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      Stack<String> stack = new Stack<>();
      String result = "YES";
      String s = br.readLine();
      for (int j = 0; j < s.length(); j++) {
        String parenthesses = s.substring(j, j + 1);
        if (parenthesses.equals("(")) {
          stack.push(parenthesses);
        } else {
          if (stack.isEmpty() || !(stack.pop().equals("("))) {
            result = "NO";
            break;
          }
        }
      }
      if (!stack.isEmpty()) {
        result = "NO";
      }
      bw.write(result + "\n");
    }
    br.close();

    // 최종 출력
    bw.flush();
    bw.close();
  }
}
