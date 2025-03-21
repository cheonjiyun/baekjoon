
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

		st = new StringTokenizer(br.readLine().trim());
		int[] sequence = new int[n + 1];
		for (int i = 0; i < n; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n]; // i에서 시작할 때 가장 긴 증가하는 수열을 기록할 예정
		Arrays.fill(dp, 1);
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) { // i 오른쪽에 있는 숫자를 다 봄
				if (sequence[i] < sequence[j]) { // 증가할 때만
					dp[i] = Math.max(dp[i], 1 + dp[j]); // 본인과 본인보다 큰 수중에서 가장 긴 수열 // 본인 // 아니면 다른 LCS
				}
			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			result = Math.max(result, dp[i]);
		}

		sb.append(result);

		System.out.println(sb);
	}
}
