

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] dp;

	public static void main(String[] args) throws Exception {
		dp = new int[41][2];

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());

			int[] result = fibonacci(n);
			sb.append(result[0]).append(" ").append(result[1]).append("\n");
		}

		System.out.println(sb);
	}

	static int[] fibonacci(int n) {
		if (dp[n][0] == 0 && dp[n][1] == 0) { // 아직 계산안했으면 계싼먼저하고

			if (n == 0) {
				dp[0][0] = 1;
				dp[0][1] = 0;
			} else if (n == 1) {
				dp[1][0] = 0;
				dp[1][1] = 1;
			} else {

				int[] n1 = fibonacci(n - 1);
				int[] n2 = fibonacci(n - 2);

				dp[n][0] += n1[0] + n2[0];
				dp[n][1] += n1[1] + n2[1];

			}
		}

		return dp[n];

	}
}
