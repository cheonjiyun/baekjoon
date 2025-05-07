import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][][] arr;
	private static int n;
	private static int h;
	private static int m;
	private static Queue<Node> q;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());


		q = new ArrayDeque<Node>();
		int tomato = 0; // 토마토 개

		arr = new int[h][n][m];
		for(int z = 0; z < h; z++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < m; j++) {
					arr[z][i][j] = Integer.parseInt(st.nextToken());
					if (arr[z][i][j] == 1) {
						q.offer(new Node(i, j, z));
					}
					if (arr[z][i][j] == 0 || arr[z][i][j] == 1) {
						tomato++;
					}
				}
			}
		}
		
//		for(int z = 0; z < h; z++) {
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(arr[z][i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		
		
		int time = -1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node cur = q.poll();

				tomato--;

				for (int d = 0; d < 4; d++) {
					int nextRow = cur.row + dr[d];
					int nextCol = cur.col + dc[d];

					qadd(nextRow, nextCol, cur.height);
				}
				

				qadd(cur.row, cur.col, cur.height - 1);
				qadd(cur.row, cur.col, cur.height + 1);
			}
			time++;
		}

		if (tomato != 0) { // 토마토 개수만큼 방문하지 않앗으면 -1
			time = -1;
		}
		sb.append(time);

		System.out.println(sb);
	}
	
	static void qadd(int nextRow, int nextCol, int height) {
		if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m || height < 0 || height >= h || arr[height][nextRow][nextCol] == 1
				|| arr[height][nextRow][nextCol] == -1) {
			return;
		}
		arr[height][nextRow][nextCol] = 1;
		q.offer(new Node(nextRow, nextCol, height));
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Node {
		int row;
		int col;
		int height;
		
		public Node(int row, int col, int height) {
			super();
			this.row = row;
			this.col = col;
			this.height = height;
		}
	}
}