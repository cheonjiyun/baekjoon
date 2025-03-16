import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int T = Integer.parseInt(st.nextToken());

    for (int testCase = 1; testCase <= T; testCase++) {
      sb.append("#").append(testCase).append(" ");
      st = new StringTokenizer(br.readLine().trim());

      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      int i = -1;
      int ns = ((i - 1) % 365) + 1;
      int ne = ((i - 1) % 24) + 1;
      int nm = ((i - 1) % 29) + 1;
      while (ns != s || ne != e || nm != m) {

        i++;
        ns = ((i - 1) % 365) + 1;
        ne = ((i - 1) % 24) + 1;
        nm = ((i - 1) % 29) + 1;
      }
      sb.append(i).append("\n");

    }
    System.out.println(sb);
  }
}