import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int MAX_VALUE = 100000000;

	static class Node {
		int adj;
		int weight;
		List<Integer> paths;

		public Node(int adj, int weight, List<Integer> paths) {
			super();
			this.adj = adj;
			this.weight = weight;
			this.paths = paths;
		}

		@Override
		public String toString() {
			return "Node [adj=" + adj + ", weight=" + weight + ", paths=" + paths + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			// 연결리스트
			List<ArrayList<Node>> adjList = new ArrayList<ArrayList<Node>>();
			for (int i = 0; i <= n; i++) {
				adjList.add(new ArrayList<Node>());
			}

			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				if ((a == g && b == h) || (a == h && b == g)) {
					adjList.get(a).add(new Node(b, d * 2 - 1, new ArrayList<>()));
					adjList.get(b).add(new Node(a, d * 2 - 1, new ArrayList<>()));
				} else {
					adjList.get(a).add(new Node(b, d * 2, new ArrayList<>()));
					adjList.get(b).add(new Node(a, d * 2, new ArrayList<>()));
				}
			}

			// djistra
			// 다음
			Queue<Node> q = new PriorityQueue<Node>(new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					return o1.weight - o2.weight;
				}
			});
			List<Integer> initPath = new ArrayList<>();
			initPath.add(s);
			q.offer(new Node(s, 0, initPath));

			// 최단길이
			int[] dist = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				dist[i] = MAX_VALUE;
			}
			dist[s] = 0;

			// 최단경로
			List[] paths = new ArrayList[n + 1];

			boolean[] visited = new boolean[n + 1];

			while (!q.isEmpty()) {
				Node shortest = q.poll();
				if (visited[shortest.adj]) {
					continue;
				}
				visited[shortest.adj] = true;

				for (Node nextNode : adjList.get(shortest.adj)) {
					if ( dist[nextNode.adj] > dist[shortest.adj] + nextNode.weight) {
						dist[nextNode.adj] = dist[shortest.adj] + nextNode.weight;

						List<Integer> newPath = new ArrayList<>();
						for (int path : shortest.paths) {
							newPath.add(path);
						}
						newPath.add(nextNode.adj);

						q.offer(new Node(nextNode.adj, dist[nextNode.adj], newPath));
						paths[nextNode.adj] = newPath;
					}
				}
			}

			List<Integer> results = new ArrayList<>();

			for (int i = 0; i < t; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());

				List<Integer> path = paths[x];
				if (path == null) {
					continue;
				}
				int length = paths[x].size();
				for (int idx = 0; idx < length - 1; idx++) {
					if ((path.get(idx) == g && path.get(idx + 1) == h)
							|| (path.get(idx) == h && path.get(idx + 1) == g)) {
						results.add(x);
					}
				}
			}

			results.sort(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			});

			for (int result : results) {
				sb.append(result).append(" ");
			}
			sb.append("\n");

		}
		System.out.println(sb);
	}
}