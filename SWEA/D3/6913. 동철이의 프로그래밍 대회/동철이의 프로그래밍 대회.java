import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
  public static void main(String args[]) throws Exception {


    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {
      int n = sc.nextInt();
      int m = sc.nextInt();

      // 입력과 동시에 1등과 몇명인지 구하기
      int maxSolving = 0;
      int count = 0;
      for (int i = 0; i < n; i++) {
        int sumSolve = 0; // 한사람당 문제풀이 개수
        for (int j = 0; j < m; j++) {
          if (sc.nextInt() == 1) {
            sumSolve += 1;
          }
        }
        if (maxSolving < sumSolve) { // 1등 교체, count 새로 시작
          maxSolving = sumSolve;
          count = 1;
        } else if (maxSolving == sumSolve) { // 1등 문제풀이개수와 같으면 +1
          count += 1;
        }
      }

      System.out.println("#" + test_case + " " + count + " " + maxSolving);
    }
  }
}