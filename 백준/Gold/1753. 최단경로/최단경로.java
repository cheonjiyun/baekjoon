import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int v;
	static List<ArrayList<Node>> adjlist;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim());
		int k = Integer.parseInt(st.nextToken());

		adjlist = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i <= v; i++) {
			adjlist.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjlist.get(start).add(new Node(end, weight));
		}

		dijstra(k);
	

		System.out.println(sb);
	}

	static int INF = 200000;
	
	private static void dijstra(int start) {

		boolean[] visited = new boolean[v + 1];

		int[] dist = new int[v + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		Queue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.end])
				continue; // 방문체크
			visited[cur.end] = true;

			for(Node next: adjlist.get(cur.end)) {
				if(dist[next.end] > dist[cur.end] + next.weight) {
					dist[next.end] = dist[cur.end] + next.weight;
					
					pq.offer(new Node(next.end, dist[next.end]));
					
				}			
			}
		}
		
		for(int i = 1; i <= v;i++) {
			if(dist[i] == INF) System.out.print("INF" + " ");
			else System.out.println(dist[i] + " ");
		}
	}

	static class Node implements Comparable<Node> {
		int end;
		int weight;

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

		public Node(int start, int weight) {
			super();
			this.end = start;
			this.weight = weight;
		}
	}
}