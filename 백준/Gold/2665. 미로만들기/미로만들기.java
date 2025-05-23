import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.sound.sampled.Line;

public class Main {
	private static int n;
	private static int[][] arr;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("src/swea_문제이름/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}

		bfs(0, 0);
		System.out.println(sb);
	}

	static void bfs(int startRow, int startCol) {
		Queue<Node> q = new PriorityQueue<Node>();
		q.offer(new Node(startRow, startCol, 0));
		boolean[][] visited = new boolean[n][n];

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (visited[cur.row][cur.col]) {
				continue;
			}
			visited[cur.row][cur.col] = true;

			if (cur.row == n - 1 && cur.col == n - 1) {
				System.out.println(cur.broke);
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nextRow = cur.row + dr[d];
				int nextCol = cur.col + dc[d];

				if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && !visited[nextRow][nextCol]) {

					if (arr[nextRow][nextCol] == 0) {
						q.offer(new Node(nextRow, nextCol, cur.broke + 1));
					} else {
						q.offer(new Node(nextRow, nextCol, cur.broke));
					}
				}
			}
		}
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Node implements Comparable<Node> {
		int row;
		int col;
		int broke;

		public Node(int row, int col, int broke) {
			super();
			this.row = row;
			this.col = col;
			this.broke = broke;
		}

		@Override
		public String toString() {
			return "Node [row=" + row + ", col=" + col + ", broke=" + broke + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.broke - o.broke;
		}

	}
}