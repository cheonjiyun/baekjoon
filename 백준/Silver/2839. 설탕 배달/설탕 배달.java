
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		
		int max5 = n / 5 + 1;
		int max3 = n /3 + 1;
		
		
		int result = -1;
		
		Loop1:
		for(int i = max5 ; i >= 0; i--) {
			
			for(int j = 0; j < max3 ; j++) {
				int remain5 = n - i * 5;
				int remain3 = remain5 - j *3;
				
				if(remain3 == 0) {
					result = i + j;
					break Loop1;
				}
			}
		}
		
		System.out.println(result);
		
	}
}
