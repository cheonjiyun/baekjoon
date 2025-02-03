import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
  public static void main(String args[]) throws Exception {

    Scanner sc = new Scanner(System.in);
    int T;
    T = 10; // 10개밖에 없네

    for (int test_case = 1; test_case <= T; test_case++) {
      int n = sc.nextInt();
      LinkedList<Integer> ciphertexts = new LinkedList<>();
      for (int i = 0; i < n; i++) {
        ciphertexts.addLast(sc.nextInt());
      }
      int m = sc.nextInt();
      for (int i = 0; i < m; i++) {
        String command = sc.next();
        if (command.equals("I")) {
          int x = sc.nextInt();
          int y = sc.nextInt();

          for (int c = 0; c < y; c++) {
            ciphertexts.add(x + c, sc.nextInt());
          }
        } else if (command.equals("D")) {
          int x = sc.nextInt();
          int y = sc.nextInt();

          for (int c = 0; c < y; c++) {
            ciphertexts.remove(x);
          }

        } else if (command.equals("A")) {
          int y = sc.nextInt();

          for (int c = 0; c < y; c++) {
            ciphertexts.add(sc.nextInt());
          }
        }
      }

      String result = "";
      Iterator it = ciphertexts.iterator();
      for (int i = 0; i < 10; i++) {
        result += it.next() + " ";
      }
      System.out.println("#" + test_case + " " + result);

    }
  }
}