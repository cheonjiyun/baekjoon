import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] fruits = new int[n];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			fruits[i] = value;			
		}
		
		Arrays.sort(fruits);
		
		for(int i = 0 ; i < n; i++) {
			if(fruits[i] <= l ) {
				l+=1;
			}
		}
	
		sb.append(l);
		

		System.out.println(sb);
	}
}
