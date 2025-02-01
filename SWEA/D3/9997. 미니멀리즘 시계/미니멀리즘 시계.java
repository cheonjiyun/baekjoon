import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
  public static void main(String args[]) throws Exception {

    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {
      int theta = sc.nextInt();

      int angleForHour = 360 / 12; // 1시간 각도 : 30
      double angleForMinute = (double) 360 / 12 / 60; // 1분 각도: 0.5
      int hour = theta / angleForHour; // 1시간 각도로 나누었을 때 몫
      int minute = (int) ((theta % angleForHour) / angleForMinute); // 1시간 각도로 나누었을 때 나머지

      System.out.println("#" + test_case + " " + hour + " " + minute);
    }
  }
}
