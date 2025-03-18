
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int ROW = 0; // 파이프라 가로로
	static int COL = 1; // 세로로
	static int DIA = 2; // 대각선
	static int WALL = -1;

	// 가로는 0인덱스에 있는 방향 인덱스로만 갈 수 있음.
	static int[][] direction = { { 0, 2 }, { 1, 2 }, { 0, 1, 2 } };

	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 0, 1 };
	private static int n;
	private static int[][] home;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());

		home = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
				if (home[i][j] == 1) { // 벽 숫자 바꾸기
					home[i][j] = WALL;
				}
			}
		}

		int[][] count = new int[n][n];
		count[0][1] = 1;

		// bfs
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(0, 1, ROW, 1));
		boolean[][][] isVisitedDir = new boolean[n][n][3];

		while (!q.isEmpty()) {
//			System.out.println(q);
			Node cur = q.poll();

//			if (isVisitedDir[cur.r][cur.c][cur.rowColDia]) {
//				continue;
//			}

			isVisitedDir[cur.r][cur.c][cur.rowColDia] = true;

			for (int nextDir : direction[cur.rowColDia]) {
				int nr = cur.r + dr[nextDir];
				int nc = cur.c + dc[nextDir];

				if (isWall(nr, nc, nextDir))
					continue;

				count[nr][nc] += 1;
				q.offer(new Node(nr, nc, nextDir, 1));
			}

//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(count[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
		}

		sb.append(count[n - 1][n - 1]);

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(count[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();

		System.out.println(sb);
	}

	static boolean isWall(int nr, int nc, int direction) {
		if (nr < 0 || nc < 0 || nr >= n || nc >= n)
			return true;
		if (direction == DIA) { // 대각선이면 4칸차지
			if (home[nr][nc] == WALL || home[nr - 1][nc] == WALL || home[nr][nc - 1] == WALL)
				return true;
		} else if (direction == ROW || direction == COL) {
			if (home[nr][nc] == WALL)
				return true;
		}

		return false;
	}

	static class Node {
		int r;
		int c;
		int rowColDia;
		int count;

		public Node(int r, int c, int rowColDia, int count) {
			super();
			this.r = r;
			this.c = c;
			this.rowColDia = rowColDia;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", rowColDia=" + rowColDia + ", count=" + count + "]";
		}
	}

}
