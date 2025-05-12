import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static ArrayDeque<RowCol> q = new ArrayDeque<RowCol>();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	private static int c;
	private static int r;
	private static Queue<RowCol> water = new ArrayDeque<RowCol>();
	private static boolean[][] visited;
	private static char[][] arr;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("src/swea_문제이름/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new char[r][c];
		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] == 'S') {
					q.offer(new RowCol(i, j, 0));
					visited[i][j] = true;
				}
				if (arr[i][j] == '*') {
					water.add(new RowCol(i, j, 0));
				}
			}
		}

		while (true) {
			int result = go();

			if (result != -1) {
				sb.append(result);
				break;
			}

			flood();
			if (q.isEmpty()) {
				sb.append("KAKTUS");
				break;
			}

		}

		System.out.println(sb);
	}

	static void flood() {
		int size = water.size();

		for (int i = 0; i < size; i++) {
			RowCol cur = water.poll();
			for (int d = 0; d < 4; d++) {
				int nextRow = cur.row + dr[d];
				int nextCol = cur.col + dc[d];

				if (nextRow < 0 || nextCol < 0 || nextRow >= r || nextCol >= c) {
					continue;
				}

				if (arr[nextRow][nextCol] == '.') {
					arr[nextRow][nextCol] = '*';
					water.offer(new RowCol(nextRow, nextCol, cur.time + 1));
				}
			}
		}
	}

	static int go() {

		int size = q.size();

		for (int i = 0; i < size; i++) {
			RowCol cur = q.poll();

			if (arr[cur.row][cur.col] == '*') {
				continue;
			}

			if (arr[cur.row][cur.col] == 'D') {
				return cur.time;
			}

			for (int d = 0; d < 4; d++) {
				int nextRow = cur.row + dr[d];
				int nextCol = cur.col + dc[d];

				if (nextRow < 0 || nextCol < 0 || nextRow >= r || nextCol >= c || arr[nextRow][nextCol] == '*'
						|| arr[nextRow][nextCol] == 'X' || arr[nextRow][nextCol] == 'S' || visited[nextRow][nextCol]) {
					continue;
				}

				visited[nextRow][nextCol] = true;
				q.offer(new RowCol(nextRow, nextCol, cur.time + 1));
			}
		}
		return -1;
	}

	static class RowCol {
		int row;
		int col;
		int time;

		public RowCol(int row, int col, int time) {
			super();
			this.row = row;
			this.col = col;
			this.time = time;
		}

		@Override
		public String toString() {
			return "RowCol [row=" + row + ", col=" + col + ", time=" + time + "]";
		}
	}
}