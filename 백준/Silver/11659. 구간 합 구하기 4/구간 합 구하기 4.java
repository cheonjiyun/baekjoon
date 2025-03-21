
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
		int m = Integer.parseInt(st.nextToken());

		int[] number = new int[n + 1];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i < n + 1; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		// 0시작 -i번째까지 합
		int[] dp = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			dp[i] = number[i] + dp[i - 1];
		}

		for (int t = 0; t < m; t++) {
			st = new StringTokenizer(br.readLine().trim());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			// j번쨰까지 합에서 i-1번 합를까지 뺀다!
			sb.append(dp[j] - dp[i - 1]).append("\n");
		}

		System.out.println(sb);
	}
}
