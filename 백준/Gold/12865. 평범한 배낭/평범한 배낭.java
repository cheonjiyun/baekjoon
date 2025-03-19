

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] weights = new int[n + 1];
		int[] values = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			weights[i] = w;
			values[i] = v;
		}

		int[][] dp = new int[n + 1][k + 1];

		// 배낭 무게가 0이면 어떤 물건도 담을 수 없다.

		for (int item = 1; item <= n; item++) {

			int itemWeight = weights[item];
			int itemValue = values[item];

			for (int weight = 1; weight <= k; weight++) {
				// 무게가 weight라는 가방에 i번째 물건을 넣을 수 있는가
				if (itemWeight <= weight) {

					// 안넣을거면 같은 무게 가방 i-1번째 가방의 값 그대로, 넣을거면 item 무게 뺀 가방 가치 + item가치
					dp[item][weight] = Math.max(dp[item - 1][weight], dp[item - 1][weight - itemWeight] + itemValue);

				}

				else {
					dp[item][weight] = dp[item - 1][weight];

				}
			}
		}

//		for (int i = 0; i <= n; i++) {
//			for (int j = 0; j <= k; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}

		sb.append(dp[n][k]);
		System.out.println(sb);
	}

	static class Item {
		int weight;
		int value;

		public Item(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Item [weight=" + weight + ", value=" + value + "]";
		}
	}
}
