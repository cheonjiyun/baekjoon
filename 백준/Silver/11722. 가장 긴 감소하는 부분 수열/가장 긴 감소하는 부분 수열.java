
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
		int[] sequence = new int[n];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n]; // i까지 가장 긴 감소하는 부분 수열
		Arrays.fill(dp, 1); // 본인만 될 때

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (sequence[j] > sequence[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			if (result < dp[i]) {
				result = dp[i];
			}
		}
		

		sb.append(result);
		System.out.println(sb);
	}
}
