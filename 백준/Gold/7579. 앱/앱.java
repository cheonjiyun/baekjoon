
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] memories = new int[n + 1];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i < n + 1; i++) {
			memories[i] = Integer.parseInt(st.nextToken());

		}

		int[] costs = new int[n + 1];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i < n + 1; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[n + 1][10000 + 1];

		int result = Integer.MAX_VALUE;

		for (int app = 1; app < n + 1; app++) {

			int appMemory = memories[app];
			int appCost = costs[app];

			for (int cost = 0; cost < 10000 + 1; cost++) {
				// app번째까지 앱을 사용할 때 비용 cost로 확보가능한 최대 메모리 크기
				if (appCost <= cost) {
					dp[app][cost] = Math.max(dp[app - 1][cost], dp[app - 1][cost - appCost] + appMemory);
				} else {
					dp[app][cost] = dp[app - 1][cost];
				}

				// 최소비용
				if (dp[app][cost] >= m)
					result = Math.min(result, cost);
			}
		}

		sb.append(result);

//		for (int i = 1; i < n + 1; i++) {
//			for (int j = 1; j < m + 1; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}

		// m이상을 확보해야하는데
		// cost가 최소인 값

		// 배낭문제처럼 완전탐색할 수 있겠지만 dp로

		// i번째 앱을 비활성화 할 지 말지.
		// ---------------- // i까지
		// | | | | | |
		// | | | | | | j만큼 메모리를 뺄 수 있어
		// .
		// .
		// . 10_000_000 까지

		System.out.println(sb);
	}

}
