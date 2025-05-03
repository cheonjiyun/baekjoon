import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][] arr;
	private static int r;
	private static int c;
	private static int[] airLocation;

	public static void main(String[] args) throws Exception {

		//System.setIn(new FileInputStream("src/baekjoon미세먼지안녕/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		arr = new int[r][c];
		airLocation = new int[2];
		int airCount = 0;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == -1) {
					airLocation[airCount++] = i;
				}
			}
		}

		for (int i = 0; i < t; i++) {
			turn();
		}
		sb.append(count());

		System.out.println(sb);
	}

	static void turn() {
		// 1. 미세먼지
		findDust();

		// 2. 공기청정
		airPurifier();
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static void findDust() {
		int[][] newArr = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] != 0) {
					// 미세먼지가 있다.
					int value = arr[i][j];
					int diffu = value / 5;

					for (int d = 0; d < 4; d++) {

						int nrow = i + dr[d];
						int ncol = j + dc[d];

						if (nrow < 0 || ncol < 0 || nrow >= r || ncol >= c || arr[nrow][ncol] == -1) {
							continue;
						}

						newArr[nrow][ncol] += diffu;
						value -= diffu;

					}
					newArr[i][j] += value;
				}
			}
		}

		arr = newArr;
	}

	static void airPurifier() {
		airPurifierUp();
		airPurifierDown();
	}

	static int[] dlr = { 1, 0, -1, 0 };
	static int[] dlc = { 0, 1, 0, -1 };

	// rotate : 1 : 위 , -1 : 아래
	static void airPurifierUp() {
		// 윗방
		int d = 0;
		int row = airLocation[0] - 1;
		int col = 0;

		while (row != airLocation[0] || col != 0) {
			// ekdma
			int nrow = row + dr[d];
			int ncol = col + dc[d];

			// 넘어서면 다음 방향 - 윗방향이면 아래를 넘거가면 안되고, 아래면 위에를 넘거가면 안됨
			if (nrow < 0 || ncol < 0 || nrow >= r || ncol >= c || nrow > airLocation[0]) {
				d += 1;
				nrow = row + dr[d];
				ncol = col + dc[d];
			}

			// 다음이 공기청정기이면 그만
			if (arr[nrow][ncol] == -1) {
				break;
			}

			arr[row][col] = arr[nrow][ncol];
			arr[nrow][ncol] = 0;
			row = nrow;
			col = ncol;

		}
	}

	static void airPurifierDown() {
		// 윗방향
		int d = 0;
		int row = airLocation[1] + 1;
		int col = 0;

		while (row != airLocation[1] || col != 0) {
			// ekdma
			int nrow = row + dlr[d];
			int ncol = col + dlc[d];

			// 넘어서면 다음 방향 - 윗방향이면 아래를 넘거가면 안되고, 아래면 위에를 넘거가면 안됨
			if (nrow < 0 || ncol < 0 || nrow >= r || ncol >= c || nrow < airLocation[1]) {
				d += 1;
				nrow = row + dlr[d];
				ncol = col + dlc[d];
			}

			// 다음이 공기청정기이면 그만
			if (arr[nrow][ncol] == -1) {
				break;
			}

			arr[row][col] = arr[nrow][ncol];
			arr[nrow][ncol] = 0;
			row = nrow;
			col = ncol;

		}
	}

	static int count() {
		int sum = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] > 0) {
					sum += arr[i][j];
				}
			}
		}
		return sum;
	}
}