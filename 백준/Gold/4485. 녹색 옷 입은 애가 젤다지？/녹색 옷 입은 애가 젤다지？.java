import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	static int INF = 99999;

	static int n;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int testCase= 0;
		while (true) {
			testCase++;
			
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;

			int[][] cave = new int[n][n];
			for (int i = 0; i < n; i++) {

				st = new StringTokenizer(br.readLine().trim());

				for (int j = 0; j < n; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 다익스트라
			boolean[][] visited = new boolean[n][n];
			int[][] dist = new int[n][n]; // 0에서 가는 가장 최소 (지금까지 아는)

			// 초기화
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = INF;
				}
			}
			dist[0][0] = cave[0][0];			

			Queue<Node> pq = new PriorityQueue<Node>();
			pq.offer(new Node(0, 0, cave[0][0]));

//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(dist[i][j] + " ");
//				}
//				System.out.println();
//			}
//			
			while (!pq.isEmpty()) {
				Node cur = pq.poll(); // 0에서 가능 가장 최소

				if (visited[cur.y][cur.x])
					continue;
				visited[cur.y][cur.x] = true;

				// cur과 연견될 노드 확인
				for (int i = 0; i < 4; i++) {
					int nx = dx[i] + cur.x;
					int ny = dy[i] + cur.y;

					if (isWall(nx, ny))
						continue; // 범위벗어남

					if (dist[ny][nx] > dist[cur.y][cur.x] + cave[ny][nx]) { // 여기를 거쳐가는게 더 빨라
						dist[ny][nx] = dist[cur.y][cur.x] + cave[ny][nx];

						pq.offer(new Node(nx, ny, dist[ny][nx]));
					}
				}
			}
			
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(dist[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			sb.append("Problem ").append(testCase).append(": ").append(dist[n-1][n-1]).append("\n");
		}

		System.out.println(sb);
	}

	static boolean isWall(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return true;
		else
			return false;
	}

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int weightFromStart;

		public Node(int x, int y, int weightFromStart) {
			super();
			this.x = x;
			this.y = y;
			this.weightFromStart = weightFromStart;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weightFromStart - o.weightFromStart;
		}

	}
}