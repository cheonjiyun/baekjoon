
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int WALL = 6;
	static int CCTVVIEW = 7;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static List<Integer>[] directionsByType = new ArrayList[6];

	static int n;
	static int m;
	static List<CCTV> cctv;
	static int[][] office;

	static int maxArea = 0;

	static class CCTV {
		int y;
		int x;
		int type;

		public CCTV(int y, int x, int type) {
			super();
			this.y = y;
			this.x = x;
			this.type = type;
		}
	}

	static class XY {
		int x;
		int y;

		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void explore(int cctvIdx, int canViewArea) {
		if (cctvIdx == cctv.size()) {
			if (canViewArea > maxArea)
				maxArea = canViewArea;
			return;
		}

		CCTV curCCTV = cctv.get(cctvIdx);

		int x = curCCTV.x;
		int y = curCCTV.y;
		int type = curCCTV.type;
		List<Integer> directions = directionsByType[type];

		// 90도씩 회전하면서
		for (int i = 0; i < 4; i++) {
			int canViewAreaThisDeg = canViewArea;
			List<XY> changeXY = new ArrayList<>();

			// CCTV가 볼 수 있는 모든 방향
			for (int direction : directions) {
				int realDirection = (direction + i) % 4; // 90 도 회전 값

				// 한 방향이 볼 수 있는
				int nx = dx[realDirection] + x;
				int ny = dy[realDirection] + y;

				while (nx >= 0 && ny >= 0 && nx < m && ny < n && office[ny][nx] != WALL) { // 벽, 벗어나느것 말고 다
					if (!(office[ny][nx] >= 1 && office[ny][nx] <= 5) && office[ny][nx] != 7) { // cctv가 아니고, 이미 볼 수 있는
																								// 곳이
																								// 아니라면
						office[ny][nx] = CCTVVIEW;
						canViewAreaThisDeg += 1; // cctv가 볼 수 있는 곳

						// 바꾼 곳 기록
						changeXY.add(new XY(nx, ny));
					}
					nx += dx[realDirection];
					ny += dy[realDirection];
				}
			}

//			System.out.println(cctvIdx);
//			System.out.println(canViewAreaThisDeg);
//			for (int z = 0; z < n; z++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(office[z][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			// 다음 CCTV
			explore(cctvIdx + 1, canViewAreaThisDeg);

			// 초기화
			for (XY xy : changeXY) {
				office[xy.y][xy.x] = 0;
			}
		}
	}

	public static void init() {
		// cctv 타입별 탐지할 수 있는 방향 배열
		// 배열 안에 리스트
		for (int i = 1; i <= 5; i++) {
			directionsByType[i] = new ArrayList<Integer>();
		}
		// 1번
		directionsByType[1].add(1);
		// 2번
		directionsByType[2].add(1);
		directionsByType[2].add(3);
		// 3번
		directionsByType[3].add(0);
		directionsByType[3].add(1);
		// 4번
		directionsByType[4].add(0);
		directionsByType[4].add(1);
		directionsByType[4].add(3);
		// 5번
		directionsByType[5].add(0);
		directionsByType[5].add(1);
		directionsByType[5].add(2);
		directionsByType[5].add(3);
	}

	public static void main(String[] args) throws Exception {

		init();

		// 입력시작---
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int areaNum = 0;

		String[] inputs = in.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		office = new int[n][m]; // 좌표

		cctv = new ArrayList<>(); // cctv 목록

		for (int i = 0; i < n; i++) {

			String[] line = in.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				int type = Integer.parseInt(line[j]);
				office[i][j] = type;

				if (type >= 1 && type <= 5) { // cctv인 경우 따로 저장
					cctv.add(new CCTV(i, j, type));
				}

				if (type == 0)
					areaNum += 1;
			}
		}

		// ---입력끝---

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(office[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		// 모든 cctv 돌면서 탐색
		explore(0, 0);

//		System.out.println(maxArea);
		int result = areaNum - maxArea;
		sb.append(result);

		System.out.println(sb);
	}

}
