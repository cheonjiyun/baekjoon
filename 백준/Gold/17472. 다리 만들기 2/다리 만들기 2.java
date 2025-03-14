import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	static int n;
	static int m;
	private static int[][] country;
	private static int[] parents;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		country = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());

			for (int j = 0; j < m; j++) {
				country[i][j] = Integer.parseInt(st.nextToken());

			}

		}

		// 1. dfs로 땅 번호 부여
		int number = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (country[i][j] == 1) {
					bfs(i, j, number);
					number++;
				}
			}
		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(country[i][j]);
//			}
//			System.out.println();
//		}

		// 2. 간선생성
		// 땅에서 현재 지점에서 출발
		// 사방으로 뻗어나감
		// 0이면 갈 수 있어
		// 2이상을 만나면 다리 생성

		List<Edge> edgeList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int ground = country[i][j];
				if (ground < 2)
					continue; // 땅이 아니면 건너뜀

				for (int d = 0; d < 4; d++) {
					int[] linkGround = searchDFS(i, j, d, 0, ground); // 땅번호 , 다리길이
					if (linkGround[0] >= 2 && linkGround[1] >= 2) {
						edgeList.add(new Edge(ground, linkGround[0], linkGround[1]));
					}
				}
			}
		}

		// 3. 간선 정렬
		Collections.sort(edgeList);

		// 4. MST - 크루스칼
		int count = 1;
		int v = number - 2;
		int size = edgeList.size();
		int mst = 0;

		makeSet(number);

		for (int i = 0; i < size; i++) {
			Edge cur = edgeList.get(i);

			if (union(cur.fromGround, cur.toGround)) {
				mst += cur.length;
				count++;

				if (count == v) {
					break;
				}
			}
		}
		


		if (count == v) {
			sb.append(mst);
		} else {
			sb.append("-1");
		}

		System.out.println(sb);
	}

	private static void makeSet(int number) {
		parents = new int[number + 1];

		for (int i = 0; i <= number; i++) {
			parents[i] = i;
		}
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot) {
			return false;
		}

		parents[aRoot] = bRoot;
		return true;
	}

	static int findSet(int a) {
		if (parents[a] == a) { // 본인이 대표자
			return a;
		}

		return parents[a] = findSet(parents[a]);
	}

	private static int[] searchDFS(int i, int j, int d, int length, int ground) {
		// 다음
		int ni = di[d] + i;
		int nj = dj[d] + j;

		if (!isOut(ni, nj)) {
			// 바다면 쭉 뻗어감
			if (country[ni][nj] == 0) { // 다음이 범위를 벗어나지 않았을 경우에만
				return searchDFS(ni, nj, d, length + 1, ground);
			}

			if (country[ni][nj] != ground && country[ni][nj] >= 2) { // 땅을 만나면
				return new int[] { country[ni][nj], length }; // 땅 번호 반환
			}
		}

		return new int[] { 0, 0 };
	}

	private static void bfs(int i, int j, int number) {
		Queue<IJ> q = new ArrayDeque<IJ>();
		q.offer(new IJ(i, j));

		while (!q.isEmpty()) {
			IJ cur = q.poll();
			country[cur.i][cur.j] = number;

			for (int d = 0; d < 4; d++) {
				int ni = di[d] + cur.i;
				int nj = dj[d] + cur.j;

				if (isOut(ni, nj))
					continue;

				if (country[ni][nj] == 1) {
					q.offer(new IJ(ni, nj));
				}
			}
		}
	}

	static class Edge implements Comparable<Edge> {
		int fromGround;
		int toGround;
		int length;

		public Edge(int fromGround, int toGround, int length) {
			super();
			this.fromGround = fromGround;
			this.toGround = toGround;
			this.length = length;
		}

		@Override
		public String toString() {
			return "Edge [fromGround=" + fromGround + ", toGround=" + toGround + ", length=" + length + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.length - o.length;
		}

	}

	static boolean isOut(int i, int j) {
		if (i < 0 || j < 0 || i >= n || j >= m)
			return true;
		else
			return false;
	}

	static class IJ {
		int i;
		int j;

		public IJ(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "IJ [i=" + i + ", j=" + j + "]";
		}

	}
}
