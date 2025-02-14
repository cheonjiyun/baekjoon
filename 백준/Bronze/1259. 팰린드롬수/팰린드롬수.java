import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    String number = sc.nextLine();
    while (!number.equals("0")) {
      String reverse = "";
      for (int i = 0; i < number.length(); i++) {
        reverse = number.charAt(i) + reverse;
      }

      System.out.println(number.equals(reverse) ? "yes" : "no");

      number = sc.nextLine();
    }
  }
}
