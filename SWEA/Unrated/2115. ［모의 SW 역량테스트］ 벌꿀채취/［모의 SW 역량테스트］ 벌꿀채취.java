import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int m;
	static int c;

	static int[] preCal;
	static int result = 0;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			result = 0;

			sb.append("#" + test_case + " ");
			st = new StringTokenizer(br.readLine().trim());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 미리 계산
			preCal = new int[n * n];
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) { // x,y에서 시작하는 벌꿀 채취 가능한

					boolean can = true;
					int[] values = new int[m];

					for (int i = 0; i < m; i++) {
						int nx = x + i;
						if (isRange(nx)) {
							// i번 째 값 저장
							values[i] = arr[y][nx];
						} else {
							// 범위를 벗어나서 재취불가
							can = false;
						}
					}

					if (can) { // 채취가 가능할때만
						// 그 범위안에서 뽑을 수 있는 최대
						preCal[n * y + x] = combinationCal(0, values, 0, 0);

					}
				}
			}
			
//			System.out.println(Arrays.toString(preCal));

			// 일꾼 선택
			for (int i = 0; i < n * n; i++) {
				for(int j = i + m; j < n*n ; j++) {
					result = Math.max(result, preCal[i] + preCal[j]);
				}
			}

			sb.append(result).append("\n");

		}

		System.out.println(sb);
	}

	static boolean isRange(int x) {
		if (x >= 0 && x < n)
			return true;
		else
			return false;
	}

	static int combinationCal(int cnt, int[] values, int sum, double pow) {
		if (sum > c) {
			// 채취한 꿀이 c를 넘어가면 불가능
			return 0;
		}

		if (cnt == m) {
			return (int) pow;
		}

		int max = 0;

		// i번째를 선택하는 경우
		max = Math.max(max, combinationCal(cnt + 1, values, sum + values[cnt], pow + Math.pow(values[cnt], 2)));

		// i번째를 선택하지 않는 경우
		max = Math.max(max, combinationCal(cnt + 1, values, sum, pow));

		return max;
	}
}