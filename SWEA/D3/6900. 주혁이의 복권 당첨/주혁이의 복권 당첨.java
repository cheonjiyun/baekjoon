
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
  public static void main(String args[]) throws Exception {

    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {
      int n = sc.nextInt();
      int m = sc.nextInt();

      HashMap<String, Integer> lotto = new HashMap<>();
      ArrayList<String> buy = new ArrayList<String>();
      for (int i = 0; i < n; i++) {
        lotto.put(sc.next(), sc.nextInt());
      }
      for (int i = 0; i < m; i++) {
        buy.add(sc.next());
      }

      int result = 0;
      for (String b : buy) {
        for (String l : lotto.keySet()) { // 다 돌면서 비교
          boolean winFlag = true;
          for (int i = 0; i < l.length(); i++) {
            if (!(l.charAt(i) == '*' || l.charAt(i) == b.charAt(i))) { // * 이거나 같은 경우가 아니면 당첨X
              winFlag = false;
              break;
            }
          }
          if (winFlag == true) {
            result += lotto.get(l);
          }
        }
      }
      System.out.println("#" + test_case + " " + result);
    }
  }
}