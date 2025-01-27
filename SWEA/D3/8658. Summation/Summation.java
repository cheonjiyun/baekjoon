
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Solution {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {

      ArrayList<Integer> numbers = new ArrayList<Integer>();
      for (int i = 0; i < 10; i++) {
        String inputs = sc.next();
        int sumNumber = 0;
        for (char number : inputs.toCharArray()) {
          sumNumber += Character.getNumericValue(number);
        }
        numbers.add(sumNumber);
      }

      System.out.println(
          "#" + test_case + " " + Collections.max(numbers) + " " + Collections.min(numbers));
    }
  }
}
