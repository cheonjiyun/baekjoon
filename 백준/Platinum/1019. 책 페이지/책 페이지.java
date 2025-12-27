import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	
	static int[] arr;

	static int digit = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken()); 
		
		arr = new int[10];
		
		int a = 1;
		int b = n;
		
		
		while(a <= b) {
			// a의 1의자리를 0으로 통일 (시작을 0으로 통일)
			while(a % 10 != 0 && a <= b) {
				individual(a);
				a++;
			}
			
			// b의 1의자리를 9로 통일(시작을 9로 통일)	
			while(b % 10 != 9 && a <= b) {
				individual(b);
				b--;
			}
			
			// 
			if(a > b) {
				break;
			}
			
			// 1의 자리 날림
			a /= 10;
			b /= 10;
			
			for(int i = 0; i < 10; i++) {
				arr[i] += (b - a + 1) * digit;
			}
			
			digit *= 10;
//			
//			for(int i = 0; i < 10; i++) {
//				System.out.print(arr[i] + " ");
//			}
//			System.out.println();
		}
		
		
		for(int i = 0; i < 10; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void individual(int i) {
		int number = i;
		while(number > 0) {
			arr[number % 10] += digit;
			number /= 10;
		}
			
	}
}