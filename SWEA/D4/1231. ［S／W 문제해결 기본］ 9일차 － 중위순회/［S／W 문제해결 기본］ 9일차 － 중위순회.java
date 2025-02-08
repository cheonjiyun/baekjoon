import java.io.FileInputStream;
import java.util.Scanner;

class Solution {


  static String resultWord = "";
  static String[] infos;
  static int[][] children;

  public static void main(String args[]) throws Exception {

    Scanner sc = new Scanner(System.in);

    for (int test_case = 1; test_case <= 10; test_case++) {
      // -- 초기화
      resultWord = "";

      // -- 입력시작
      int n = Integer.valueOf(sc.nextLine());

      infos = new String[n + 1];
      children = new int[n + 1][2];
      for (int i = 1; i <= n; i++) {
        String[] inputs = sc.nextLine().split(" ");
        int number = Integer.valueOf(inputs[0]);
        infos[i] = inputs[1];

        if (inputs.length >= 3) {
          children[i][0] = Integer.valueOf(inputs[2]);
        }
        if (inputs.length >= 4) {
          children[i][1] = Integer.valueOf(inputs[3]);
        }
      }
      // -- 입력 끝 --
      readbfs(1);
      System.out.printf("#%d %s\n", test_case, resultWord);
    }
  }

  public static void readbfs(int nodeNumber) {

    if (children[nodeNumber][0] != 0) {
      readbfs(children[nodeNumber][0]);
    }
    resultWord += infos[nodeNumber];
    if (children[nodeNumber][1] != 0) {
      readbfs(children[nodeNumber][1]);
    }
  }
}
