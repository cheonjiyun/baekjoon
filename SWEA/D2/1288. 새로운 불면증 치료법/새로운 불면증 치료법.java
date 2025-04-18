import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Scanner;
 
class Solution {
  public static void main(String args[]) throws Exception {
 
    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();
 
    for (int test_case = 1; test_case <= T; test_case++) {
      int number = sc.nextInt();
 
      HashSet<Integer> count = new HashSet<Integer>();
 
      int i = 1;
      int result = 0;
      while (count.size() < 10) {
        int ni = number * i;
        result = ni;
 
        for (String s : String.valueOf(ni).split("")) {
          count.add(Integer.valueOf(s));
        }
        i++;
      }
      System.out.println("#" + test_case + " " + result);
    }
  }
}