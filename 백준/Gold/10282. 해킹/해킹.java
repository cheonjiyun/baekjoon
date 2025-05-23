import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static ArrayList<ArrayList<Node>> adjList;
	private static boolean[] visited;
	private static int count;
	private static int max;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("src/swea_문제이름/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			count = 0;
			max = 0;

			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adjList = new ArrayList<ArrayList<Node>>();
			for (int i = 0; i <= n; i++) {
				adjList.add(new ArrayList<>());
			}

			for (int i = 0; i < d; i++) {

				st = new StringTokenizer(br.readLine().trim());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				adjList.get(b).add(new Node(a, s));
			}

//			for (int i = 0; i <= d; i++) {
//				System.out.println(adjList.get(i));
//			}

			visited = new boolean[n + 1];
			bfs(c);

			sb.append(count).append(" ").append(max);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void bfs(int startComputer) {
		Queue<Node> q = new PriorityQueue<Node>();
		q.offer(new Node(startComputer, 0));

		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (visited[cur.depend]) {
				continue;
			}
			visited[cur.depend] = true;
			count++;
			max = Math.max(max, cur.time);

			for (Node adj : adjList.get(cur.depend)) {
				if (!visited[adj.depend]) {
					q.offer(new Node(adj.depend, cur.time + adj.time));

				}
			}
		}
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Node implements Comparable<Node> {
		int depend;
		int time;

		public Node(int depend, int time) {
			super();
			this.depend = depend;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Node [depend=" + depend + ", time=" + time + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}
}