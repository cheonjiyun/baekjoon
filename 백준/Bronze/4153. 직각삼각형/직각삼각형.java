import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);


    while (sc.hasNextLine()) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      if (a == 0 && b == 0 && c == 0)
        break;

      boolean aa = c * c + b * b == a * a;
      boolean bb = a * a + c * c == b * b;
      boolean cc = a * a + b * b == c * c;


      String result = aa || bb || cc ? "right" : "wrong";
      System.out.println(result);


    }
    sc.close();
  }
}