import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int[][] arr;
	private static int n;
	private static int m;
	private static ArrayDeque<RowCol> iceberg;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("src/swea_문제이름/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		iceberg = new ArrayDeque<RowCol>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > 0) {
					iceberg.offer(new RowCol(i, j));
				}
			}
		}

		int year = 0;
		while (true) {

			int countValue = count();
			if (countValue >= 2) {
				sb.append(year);
				break;
			} else if (countValue <= 0) {
				sb.append(0);
				break;
			}

			melt();
			year++;
		}

		System.out.println(sb);
	}

	static class RowCol {
		int row;
		int col;

		public RowCol(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}

	public static void melt() {
		int[][] newArr = new int[n][m];

		int size = iceberg.size();

		for (int turn = 0; turn < size; turn++) {

			RowCol current = iceberg.poll();

			if (arr[current.row][current.col] == 0) {
				continue;
			}

			int currentValue = arr[current.row][current.col];
			for (int d = 0; d < 4; d++) {
				int nextRow = current.row + dr[d];
				int nextCol = current.col + dc[d];

				if (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m && arr[nextRow][nextCol] == 0) {
					currentValue--;
				}
			}

			if (currentValue < 0) {
				currentValue = 0;
			} else {
				iceberg.offer(new RowCol(current.row, current.col));
			}

			newArr[current.row][current.col] = currentValue;

		}
		arr = newArr;
	}

	public static int count() {
		boolean[][] visited = new boolean[n][m];
		int sum = 0;

		int size = iceberg.size();

		for (int turn = 0; turn < size; turn++) {
			RowCol current = iceberg.poll();

			if (arr[current.row][current.col] != 0 && !visited[current.row][current.col]) {
				dfs(current.row, current.col, visited);
				sum++;
			}

		}
		return sum;
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void dfs(int row, int col, boolean[][] visited) {

		iceberg.offer(new RowCol(row, col));

		for (int d = 0; d < 4; d++) {
			int nextRow = row + dr[d];
			int nextCol = col + dc[d];

			if (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m && arr[nextRow][nextCol] != 0
					&& !visited[nextRow][nextCol]) {
				visited[nextRow][nextCol] = true;

				dfs(nextRow, nextCol, visited);
			}
		}
	}
}