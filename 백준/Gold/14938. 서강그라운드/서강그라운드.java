
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static ArrayList<ArrayList<Node>> adjList;
	private static int m;
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[n + 1];
		adjList = new ArrayList<ArrayList<Node>>();
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			adjList.get(a).add(new Node(a, b, l));
			adjList.get(b).add(new Node(b, a, l));
		}

		int answer = 0;
		for (int i = 1; i <= n; i++) {
			answer = Math.max(answer, dikstra(i));
		}
		sb.append(answer);
		System.out.println(sb);
	}

	static final long INF = 999999;

	static int dikstra(int start) {
		long[] dist = new long[n + 1];
		for (int i = 0; i < n + 1; i++) {
			dist[i] = INF;
		}
		dist[start] = 0;

		boolean[] visited = new boolean[n + 1];
		Queue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start, start, 0));

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.length > m) {
				continue;
			}
			if (visited[cur.end]) {
				continue;
			}
			visited[cur.end] = true;

			for (Node adj : adjList.get(cur.end)) {
				if (dist[adj.end] > cur.length + adj.length && cur.length + adj.length <= m) {
					dist[adj.end] = cur.length + adj.length;
					q.offer(new Node(adj.start, adj.end, cur.length + adj.length));
				}
			}
		}

		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (dist[i] <= m) {
				result += arr[i];
			}
		}
		return result;
	}

	static class Node implements Comparable<Node> {
		int start;
		int end;
		int length;

		public Node(int start, int end, int length) {
			super();
			this.start = start;
			this.end = end;
			this.length = length;
		}

		@Override
		public String toString() {
			return "Node [start=" + start + ", end=" + end + ", length=" + length + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.length - o.length;
		}

	}
}
