import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] qu = new int[26];

    String input = sc.nextLine();
    for (char c : input.toCharArray()) {

      qu[c - 'a'] += 1;
    }

    for (int i = 0; i < qu.length; i++) {
      System.out.print(qu[i] + " ");
    }
  }
}
