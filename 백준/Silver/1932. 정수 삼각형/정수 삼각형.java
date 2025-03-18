
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

		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// DP
		// 각 자리에서 가질 수 있는 최댓값을 미리 계산해놓는다.
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = arr[i][j];
				if (j - 1 >= 0) {
					arr[i][j] += Math.max(arr[i - 1][j], arr[i - 1][j - 1]);
				} else {
					arr[i][j] += arr[i - 1][j];
				}
			}
		}

		int result = 0;
		for (int j = 0; j < n; j++) {
			result = Math.max(result, arr[n - 1][j]);
		}

		sb.append(result);
		System.out.println(sb);
	}
}
