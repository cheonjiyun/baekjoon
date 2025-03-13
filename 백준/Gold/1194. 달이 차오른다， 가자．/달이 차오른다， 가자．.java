
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static char[][] maze;

	static int n;
	static int m;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		maze = new char[n][m];

		Node start = new Node(0, 0, 0, 0);
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			maze[i] = st.nextToken().toCharArray();
			for (int j = 0; j < m; j++) {
				if (maze[i][j] == '0') {
					start = new Node(i, j, 0, 0);
				}
			}
		}

		sb.append(bfs(start));
		System.out.println(sb);
	}

	private static int bfs(Node start) {

		Queue<Node> q = new ArrayDeque<Node>();
		boolean[][][] visited = new boolean[n][m][64];
	
		visited[start.r][start.c][0] = true;
		q.offer(start);

		while (!q.isEmpty()) {
//			System.out.println(q);
			Node cur = q.poll();

			int r = cur.r;
			int c = cur.c;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (isWall(nr, nc)) // 벽.
					continue;

				if (maze[nr][nc] == '1') // 탈출!
					return cur.count + 1;

				// 가려는 곳이 방문했는가
				if (visited[nr][nc][cur.haveKey]) { // 키 묶음이 같으면 패스
					continue;
				}

				// 새로운 키 묶음

				int newKey = cur.haveKey;

				if (maze[nr][nc] >= 'a' && maze[nr][nc] <= 'f') { // 열쇠를 집는다.
					int key = 1 << (maze[nr][nc] - 'a');
					newKey = key | cur.haveKey;
					// key 추가하기
				}

				if (maze[nr][nc] >= 'A' && maze[nr][nc] <= 'F') { // 문이라면
					int door = maze[nr][nc] - 'A'; // 001000 : C 열쇠에 따라 비트로 저장
					if (!isHaveKey(door, cur.haveKey)) { // 키 없으면 패스
						continue;
					}
				}

				visited[nr][nc][newKey] = true; // 방문 갱신
				
//				for(int z = 0; z < n; z++) {
//					for(int j = 0; j < m; j++) {
//						System.out.print(visited[z][r]);
//					}
//					System.out.println();
//				}
//				System.out.println();
				q.offer(new Node(nr, nc, cur.count + 1, newKey));
			}
		}

		return -1;

	}

	static boolean isHaveKey(int door, int haveKey) {
		return (haveKey & 1 << door) == (int) Math.pow(2, door); // 가지고 있다면
	}

	static boolean isWall(int r, int c) {
		if (r < 0 || c < 0 || r >= n || c >= m || maze[r][c] == '#')
			return true;
		else
			return false;
	}

	static class Node {
		int r;
		int c;
		int count;
		int haveKey;

		public Node(int r, int c, int count, int haveKey) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
			this.haveKey = haveKey;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", count=" + count + ", haveKey=" + haveKey + "]";
		}
	}
}
