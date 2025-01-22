import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long sum = 0;
        String line = scanner.nextLine();
        Scanner lineScanner = new Scanner(line);

        while (lineScanner.hasNext()) {
            sum += lineScanner.nextLong();
        }

        System.out.println(sum);

    }
}