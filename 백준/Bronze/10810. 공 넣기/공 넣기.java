import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    int[] basket = new int[n];

    for (int loap = 0; loap < m; loap++) {
      int i = sc.nextInt() - 1;
      int j = sc.nextInt() - 1;
      int k = sc.nextInt();

      for (int idx = i; idx <= j; idx++) {
        basket[idx] = k;
      }

    }

    for (int i = 0; i < n; i++) {
      System.out.print(basket[i] + " ");
    }
  }
}
