import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[][] arr;
	private static int[] dr = { 1, 0, -1, 0 };
	private static int[] dc = { 0, 1, 0, -1 };
	private static int k;
	private static int[][] commands;
	private static int n;
	private static int m;
	private static int result = Integer.MAX_VALUE;
	private static int[][] backup;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n + 1][m + 1];
		backup = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				backup[i][j] = arr[i][j];
			}
		}

		commands = new int[k][3];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			commands[i] = new int[] { r, c, s };
		}

		// 1. 순열
		// 2. 돌리기
		// 3. 행합 최솟값

		// 순열
		permutation(0, new boolean[k], new int[k]);

		sb.append(result);

		System.out.println(sb);
	}

	public static int getMin() {
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= m; j++) {
				sum += arr[i][j];
			}
			if (sum < min) {
				min = sum;
			}
		}
		return min;
	}

	public static void permutation(int cnt, boolean[] selected, int[] ordered) {
		if (cnt == k) {
			// 이 순서대로
			commandRotates(ordered);
			result = Math.min(result, getMin());
			return;
		}

		for (int i = 0; i < k; i++) {
			if (selected[i])
				continue;
			selected[i] = true;

			ordered[cnt] = i;
			permutation(cnt + 1, selected, ordered);

			selected[i] = false;

		}
	}

	public static void commandRotates(int[] ordered) {
		// 다시 새로
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				arr[i][j] = backup[i][j];
			}
		}

		// 순서대로 돌리기
		for (int i = 0; i < k; i++) {
			int order = ordered[i];
			int r = commands[order][0];
			int c = commands[order][1];
			int s = commands[order][2];

			for (int loop = 1; loop <= s; loop++) {
				rotate(r - loop, c - loop, r + loop, c + loop);
			}
		}
	}

	public static void rotate(int startRow, int startCol, int endRow, int endCol) {
		// 진짜 돌리기
		int row = startRow;
		int col = startCol;
		int temp = arr[row][col];

		int direction = 0;
		while (direction < 4) {

			int nRow = row + dr[direction];
			int nCol = col + dc[direction];

			if (nRow < startRow || nRow > endRow || nCol < startCol || nCol > endCol) {
				direction++;
				continue;
			}

			arr[row][col] = arr[nRow][nCol];

			row = nRow;
			col = nCol;
		}

		arr[row][col + 1] = temp;
	}
}
