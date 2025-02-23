import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);


    int[] bun = new int[3];
    bun[0] = sc.nextInt();
    bun[1] = sc.nextInt();
    bun[2] = sc.nextInt();

    Arrays.sort(bun);

    if (bun[0] + bun[1] <= bun[2]) {
      bun[2] = bun[0] + bun[1] - 1;
    }

    System.out.println(bun[0] + bun[1] + bun[2]);

    sc.close();
  }
}