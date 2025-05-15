import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] parent = new int[100001];

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("src/swea_문제이름/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(new Node(n, 0));
		boolean[] visited = new boolean[100001];
		visited[n] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.x == k) {
				sb.append(cur.time).append("\n");

				ArrayDeque<Integer> path = new ArrayDeque<>();

				int p = cur.x;
				while (true) {
					path.offerFirst(p);

					if (p == n) {
						break;
					}

					p = parent[p];
				}

				while (!path.isEmpty()) {
					sb.append(path.poll()).append(" ");
				}

			}

			for (int next : new int[] { cur.x - 1, cur.x + 1, 2 * cur.x }) {
				if (next >= 0 && next <= 100000 && !visited[next]) {
					visited[next] = true;
					q.offer(new Node(next, cur.time + 1));
					parent[next] = cur.x;
				}
			}

		}

		System.out.println(sb);
	}

	static class Node {
		int x;
		int time;

		public Node(int x, int time) {
			super();
			this.x = x;
			this.time = time;
		}
	}
}