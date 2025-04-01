import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int m;
	private static int[][] candies;
	static int[] dp;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			m = (int) (Double.parseDouble(st.nextToken()) * 100);

			dp = new int[m + 1];

			if (n == 0 && m == 0.0) {
				break; // 입력끝
			}

			candies = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int c = Integer.parseInt(st.nextToken());
				double p = Double.parseDouble(st.nextToken());

				candies[i][0] = c;
				candies[i][1] = (int) (p * 100 + 0.5);
			}

			sb.append(memoi(m)).append("\n");
		}
		System.out.println(sb);
	}

	// 가격 price일 대 최대 dp
	// 100배수
	public static int memoi(int price) {
		if (dp[price] == 0) {
			for (int i = 0; i < n; i++) {
				int candyCalorie = candies[i][0];
				int candyPrice = candies[i][1];
				if (price - candyPrice >= 0) {
					dp[price] = Math.max(dp[price], memoi(price - candyPrice) + candyCalorie);
				}
			}

		}
		return dp[price];
	}
}
