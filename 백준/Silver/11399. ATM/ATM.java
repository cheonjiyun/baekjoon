import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());

		int[] ATM = new int[n];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			ATM[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(ATM);

		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				result += ATM[j];
			}
		}
		
		sb.append(result);
		

		System.out.println(sb);
	}
}