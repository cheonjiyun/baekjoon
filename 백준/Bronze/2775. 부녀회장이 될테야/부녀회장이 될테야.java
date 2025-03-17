
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
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(br.readLine().trim());
			int k = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());

			int[][] apt = new int[k+1][n + 1];
			// 0층 1호부터 i호까지
			for (int i = 1; i <= n; i++) {
				apt[0][i] = i;
			}
			for (int i = 1; i <= k; i++) {
				for (int j = 1; j <= n; j++) {
					// 자신의 아래층
					for (int h = 1; h <= j; h++) {
						apt[i][j] += apt[i - 1][h];

					}
				}
			}
			
			sb.append(apt[k][n]).append("\n");
//			for (int i = k; i >= 0; i--) {
//				System.out.println(Arrays.toString(apt[i]));
//			}
			
		}

		System.out.println(sb);
	}

}
