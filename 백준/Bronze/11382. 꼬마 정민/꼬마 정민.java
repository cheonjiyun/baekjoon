import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long sum = 0;
		
		String line = sc.nextLine();
		Scanner lineScanner = new Scanner(line);
		
		while(lineScanner.hasNext()) {
			sum += lineScanner.nextLong();
		}
		
		System.out.println(sum);		
	}
}