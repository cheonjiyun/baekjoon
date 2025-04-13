import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    char[] string = br.readLine().toCharArray();

    String result = "";

    for (int i = 0; i < string.length; i++) {
      char shifted = (char) (string[i] - 3);
      if (shifted < 'A') {
        shifted += 26;
      }
      if (shifted > 'Z') {
        shifted -= 26;
      }
      result += Character.valueOf(shifted);
    }

    sb.append(result);

    System.out.println(sb);
  }
}