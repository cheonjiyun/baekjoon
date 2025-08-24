import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int[][] segmentTree;
	private static int LEN;
	private static int n;

	static void update(int x, int y, int value) {
	    int currentIdxX = LEN - 1 + y;
	    int currentIdxY = LEN - 1 + x;

	    // 1) 리프 갱신
	    segmentTree[currentIdxY][currentIdxX] = value;

	    // 2) 같은 y행에서 x-부모 경로 갱신
	    int tempX = currentIdxX;
	    while (tempX > 1) {
	        tempX /= 2;
	        segmentTree[currentIdxY][tempX] =
	            segmentTree[currentIdxY][tempX * 2] + segmentTree[currentIdxY][tempX * 2 + 1];
	    }

	    // 3) y를 올리면서 매 y레벨에서 x-경로 갱신
	    int tempY = currentIdxY;
	    while (tempY > 1) {
	        tempY /= 2;

	        int tx = currentIdxX;

	        // (a) 그 y레벨의 x-리프(curX) 값을 먼저 자식 y행 합으로 최신화
	        segmentTree[tempY][tx] =
	            segmentTree[tempY * 2][tx] + segmentTree[tempY * 2 + 1][tx];

	        // (b) 그 다음, 같은 y레벨에서 x-부모들을 위로 올리며 갱신 (x-자식 합!)
	        while (tx > 1) {
	            tx /= 2;
	            segmentTree[tempY][tx] =
	                segmentTree[tempY][tx * 2] + segmentTree[tempY][tx * 2 + 1];
	        }
	    }
	}

	static long sumX(int idxX, int xs, int xe, int x1, int y1, int x2, int y2) {
		if (x2 < xs || xe < x1) {
			return 0;
		}

		if (xs >= x1 && xe <= x2) {
			return sumY(1, idxX, 1, LEN, y1, y2);
		}

		int midx = (xs + xe) / 2;
		return sumX(idxX * 2, xs, midx, x1, y1, x2, y2) + sumX(idxX * 2 + 1, midx + 1, xe, x1, y1, x2, y2);

	}

	static int sumY(int idxY, int idxX, int ys, int ye, int y1, int y2) {
		if (y2 < ys || ye < y1) {
			return 0;
		}

		if (ys >= y1 && ye <= y2) {
			return segmentTree[idxY][idxX];
		}
		int midx = (ys + ye) / 2;
		return sumY(idxY * 2, idxX, ys, midx, y1, y2) + sumY(idxY * 2 + 1, idxX, midx + 1, ye, y1, y2);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		LEN = 1;
		while (LEN < n) {
			LEN *= 2;
		}

		int SIZE = LEN * 2;
		segmentTree = new int[SIZE][SIZE];

		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < n; x++) {

				segmentTree[LEN + y][LEN + x] = Integer.parseInt(st.nextToken());
			}
		}

		// 초기 세팅
		// x
		for (int y = LEN; y < SIZE; y++) {
			for (int x = LEN - 1; x >= 1; x--) {
				segmentTree[y][x] = segmentTree[y][x * 2] + segmentTree[y][x * 2 + 1];
			}
		}

		// y
		for (int y = LEN - 1; y >= 1; y--) {
			for (int x = 1; x < SIZE; x++) {
				segmentTree[y][x] = segmentTree[y * 2][x] + segmentTree[y * 2 + 1][x];
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int w = Integer.parseInt(st.nextToken());
			if (w == 0) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				update(x, y, c);
			} else if (w == 1) {
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());

				sb.append(sumX(1, 1, LEN, y1, x1, y2, x2)).append("\n");
			}
		}
		System.out.println(sb);
	}
}