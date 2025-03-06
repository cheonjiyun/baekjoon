
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] dist;
	static List<ArrayList<Node>> adjList;
	static int INF = 200000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		dist = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				dist[i][j] = INF;

			}
		}

		adjList = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adjList.get(a).add(new Node(b, c));
			adjList.get(b).add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine().trim());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		dijsta(1);
		dijsta(v1);
		dijsta(v2);

		int way1 = dist[1][v1] + dist[v1][v2] + dist[v2][n];
		int way2 = dist[1][v2] + dist[v2][v1] + dist[v1][n];
		int result = Math.min(way1, way2);
		if (result >= INF) {
			result = -1;
		}

		sb.append(result);
		System.out.println(sb);
	}

	static public void dijsta(int start) {
		Queue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0)); // 시작점 추가

		dist[start][start] = 0;

		boolean[] visited = new boolean[n + 1];

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.end])
				continue;
			visited[cur.end] = true;

			for (Node adj : adjList.get(cur.end)) {
				if (dist[start][adj.end] > dist[start][cur.end] + adj.weight) {
					dist[start][adj.end] = dist[start][cur.end] + adj.weight;

					pq.offer(new Node(adj.end, dist[start][adj.end])); // 바뀌었어요
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int end;
		int weight;

		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [end=" + end + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
}
