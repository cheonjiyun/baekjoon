import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    String s = sc.nextLine();
    for (int i = 0; i < s.length(); i += 10) {
      if (i + 10 < s.length()) {
        System.out.println(s.substring(i, i + 10));
      } else {
        System.out.println(s.substring(i));
      }
    }
  }
}
