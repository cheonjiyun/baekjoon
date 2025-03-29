
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.sound.midi.Soundbank;

public class Main {

	static int[] dc = { 0, 1, 0, -1 };
	static int[] dr = { -1, 0, 1, 0 };
	private static int[][] board;
	private static int result;
	static Queue<Integer> wall;

	static final int N = 5;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int k = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		board = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine().trim());
		wall = new ArrayDeque<>();
		for (int i = 0; i < m; i++) {
			wall.offer(Integer.parseInt(st.nextToken()));
		}

		// --------------입력 끝------------------


		int turn = 1;
		while (turn <= k) {

			result = 0;
			// 뺄 유물조각 선택하기
			Max max = maxRelic();

			if (max.relicList.size() >= 3) {
				putAndIn(max.newBoard, max.relicList);

				while (true) {

					List<RowCol> sum = getSumRelic(board);
					if (sum.size() >= 3) {
						putAndIn(board, sum);
					} else {
						break;
					}
				}

			}else {
				break;
			}
			turn++;
			
			sb.append(result).append(" ");
		}

		System.out.println(sb);
	}

	// 유물뺴고 넣기
	public static void putAndIn(int[][] newBoard, List<RowCol> relicList) {
		// 가장 많은 유물인 상태로 회전상태
		board = newBoard;

		// 유물 조각 빼기
		for (RowCol relic : relicList) {
			board[relic.row][relic.col] = 0;
			result++;
		}

		// 유물 채우기
		for (int col = 0; col < N; col++) {
			for (int row = N - 1; row >= 0; row--) {
				if (board[row][col] == 0) {
					int number = wall.poll();
					board[row][col] = number;
					wall.offer(number);
				}
			}
		}

	}

//	 가장 높은 곳 선택
	public static Max maxRelic() {
		// 1) 어디서 -어느각도로
		// 1~3 1~3 9군데
		// 0도부터 270도까지
		Max max = new Max(new RowCol(N, N), 5, new ArrayList<>(), new int[N][N]);

		for (int row = 1; row < N - 1; row++) {
			for (int col = 1; col < N - 1; col++) {
				// 이걸로 4번 돌릴거임

				for (int rotate = 0; rotate < 3; rotate++) {

					// 돌린 배열
					int[][] newBoard = rotate(row, col, rotate);

					// 유물 조각이 3개 이상 있는지 확인
					List<RowCol> sum = getSumRelic(newBoard);
					if (sum.size() < 3)
						continue;

					// 이 회전에서 얻는 값이 지금 값보다 많은 경우
					if (sum.size() > max.relicList.size()
							|| (sum.size() == max.relicList.size() && rotate < max.direction)
							|| (sum.size() == max.relicList.size() && rotate == max.direction && col < max.location.col)
							|| (sum.size() == max.relicList.size() && rotate == max.direction && col == max.location.col
									&& row < max.location.row)

					) {
						max.location.row = row;
						max.location.col = col;

						max.direction = rotate;
						max.relicList = sum;
						max.newBoard = newBoard;

					}

				}
			}
		}

		return max;

		// 3) 유물 채우기
		// 아래서부터 - 왼쪾부터 for문

		// 4) 1번부터 반복 (연쇄)
	}

	private static int[][] rotate(int row, int col, int rotate) {

		int length = 3;
		int[][] boardSub = new int[3][3];
		int[][] newBoardSub = new int[3][3];
		int[][] newBoard = new int[N][N];

		// 3x3만 뽑기
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				boardSub[i][j] = board[row - 1 + i][col - 1 + j];
			}
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (rotate == 0) { // 90도
					newBoardSub[i][j] = boardSub[length - 1 - j][i];
				} else if (rotate == 1) { // 180도
					newBoardSub[i][j] = boardSub[length - 1 - i][length - 1 - j];
				} else if (rotate == 2) { // 270도
					newBoardSub[i][j] = boardSub[j][length - 1 - i];
				}
			}
		}

		// 이 위치에서 활용할 새로운 배열
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newBoard[i][j] = board[i][j];
			}
		}

		// 회전한 배열 집어넣기
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				newBoard[row - 1 + i][col - 1 + j] = newBoardSub[i][j];
			}
		}

		return newBoard;
	}

	private static List<RowCol> getSumRelic(int[][] newBoard) {

		boolean[][] visited = new boolean[N][N];

		List<RowCol> sumList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j])
					continue;
				List<RowCol> countList = getRelicCount(newBoard, newBoard[i][j], new RowCol(i, j), visited);
				if (countList.size() >= 3) {
					for (RowCol relic : countList) {
						sumList.add(relic);
					}
				}
			}
		}
		return sumList;
	}

	private static List<RowCol> getRelicCount(int[][] newBoard, int relicNumber, RowCol start, boolean[][] visited) {

		Queue<RowCol> q = new ArrayDeque<RowCol>();
		q.offer(start);

		visited[start.row][start.col] = true;

		List<RowCol> countList = new ArrayList<>();
		while (!q.isEmpty()) {
			RowCol cur = q.poll();
			countList.add(cur);

			for (int d = 0; d < 4; d++) {
				int nr = cur.row + dr[d];
				int nc = cur.col + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && newBoard[nr][nc] == relicNumber && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new RowCol(nr, nc));
				}
			}
		}

		return countList;
	}

	static class Max {
		RowCol location;
		int direction;
		List<RowCol> relicList = new ArrayList<>();
		int[][] newBoard;

		public Max(RowCol location, int direction, List<RowCol> relicList, int[][] newBoard) {
			super();
			this.location = location;
			this.direction = direction;
			this.relicList = relicList;
			this.newBoard = newBoard;
		}

		@Override
		public String toString() {
			return "Max [location=" + location + ", direction=" + direction + ", relicList=" + relicList + ", newBoard="
					+ Arrays.toString(newBoard) + "]";
		}

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
