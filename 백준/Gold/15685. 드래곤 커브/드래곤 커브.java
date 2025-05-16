import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	static int result = 0;
	private static boolean[][] board;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("src/swea_문제이름/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());

		board = new boolean[101][101]; // 상 우하 좌

		for (int cz = 0; cz < n; cz++) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			// 1. 선 긋기
			List<Integer> rotates = new ArrayList<>();
			boolean reverse = false;

			int nextY = y + dr[d];
			int nextX = x + dc[d];
			board[y][x] = true;
			board[nextY][nextX] = true;
			rotates.add(d);

			// 1단계부터
			for (int level = 1; level <= g; level++) {

				int size = rotates.size();
				for (int i = size - 1; i >= 0; i--) {
					int rotate = rotates.get(i);

					// 지금까지 뒤에서부터 반시계로 회전
					d = (rotate + 1 + 4) % 4;
					rotates.add(d);
					y = nextY;
					x = nextX;

					nextY = y + dr[d];
					nextX = x + dc[d];
					
					board[y][x] = true;
					board[nextY][nextX] = true;
				}

				reverse = !reverse;
			}

		}

		
		// 2. 네 꼭지점
		for(int i = 0; i< 100; i++) {
			for(int j = 0; j < 100; j++) {		
				if(board[i][j] &&  board[i+1][j] && board[i][j+1] && board[i+1][j+1]) {
					result++;
				}
			}
		}
		
		sb.append(result);


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

		@Override
		public String toString() {
			return "RowCol [row=" + row + ", col=" + col + "]";
		}

	}

}