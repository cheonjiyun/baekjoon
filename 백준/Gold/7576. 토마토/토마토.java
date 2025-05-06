import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		Queue<Node> q = new ArrayDeque<Node>();
		int tomato = 0; // 토마토 개

		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					q.offer(new Node(i, j));
				}
				if (arr[i][j] == 0 || arr[i][j] == 1) {
					tomato++;
				}
			}
		}

		int time = -1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node cur = q.poll();

				tomato--;

				for (int d = 0; d < 4; d++) {
					int nextRow = cur.row + dr[d];
					int nextCol = cur.col + dc[d];

					if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m || arr[nextRow][nextCol] == 1
							|| arr[nextRow][nextCol] == -1) {
						continue;
					}
					arr[nextRow][nextCol] = 1;
					q.offer(new Node(nextRow, nextCol));
				}
			}
			time++;
		}

		if (tomato != 0) { // 토마토 개수만큼 방문하지 않앗으면 -1
			time = -1;
		}
		sb.append(time);

		System.out.println(sb);
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Node {
		int row;
		int col;

		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
}