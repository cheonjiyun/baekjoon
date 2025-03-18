
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1149 RGB거리
public class Main {
	private static int n;
	private static int[][] rgb;
	private static int result;
	private static int[][] memo;

	public static void main(String[] args) throws Exception {
		result = Integer.MAX_VALUE;

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());

		rgb = new int[n][3];
		memo = new int[n][3]; // n까지 왔을 때 i를 선택했을 때 최소값.
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());

			for (int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		dfs(0, -1, 0);
		for (int j = 0; j < 3; j++) {
			int r = dp(n - 1, j);
			result = Math.min(result, r);
		}
		sb.append(result);


		System.out.println(sb);
	}

	static int dp(int line, int col) {
		if (memo[line][col] == 0) { // dp memo 를 아직 안했으면
			if (line == 0) {
				for (int j = 0; j < 3; j++) {
					memo[line][j] = rgb[line][j];
				}
			} else {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < 3; j++) {
					if (col == j)
						continue;// 같은 색은 통과
					min = Math.min(min, dp(line - 1, j) + rgb[line][col]);
				}
				memo[line][col] = min;
			}
		}

		return memo[line][col];

	}

//	static void dfs(int line, int before, int sum) {
//		if (sum > result)
//			return;
//
//		if (line == n) {
//			result = Math.min(result, sum);
//			return;
//		}
//
//		for (int i = 0; i < 3; i++) {
//			if (i == before) {
//				continue;
//			}
//
//			dfs(line + 1, i, sum + rgb[line][i]);
//
//		}
//	}
}
