import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static ArrayList<ArrayList<Node>> adjList;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("src/swea_문제이름/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		adjList = new ArrayList<ArrayList<Node>>();
		for(int i = 0; i <=n;i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m ;i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adjList.get(a).add(new Node(b,c));
			adjList.get(b).add(new Node(a,c));
		}
		
		dijstra(1);
		System.out.println(sb);
	}
	
	static int INF = 50000*1000+1;
	static void dijstra(int start) {
		
		Queue<Node> q = new PriorityQueue<Main.Node>();
		q.offer(new Node(start, 0));
		boolean[] visited = new boolean[n+1];
		
		int[] dist = new int[n+1];
		for(int i = 0 ;i <= n;i++) {
			dist[i] = INF;
		}
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
//			System.out.println(cur);
			
			if(visited[cur.adj]) {
				continue;
			}
			visited[cur.adj] = true;
			
			for(Node adjNode : adjList.get(cur.adj)) {
				if(dist[adjNode.adj] > adjNode.cow + dist[cur.adj]) {
					dist[adjNode.adj] = adjNode.cow + dist[cur.adj];
					q.offer(new Node(adjNode.adj, dist[adjNode.adj]));
				}
			}
		}
		System.out.println(dist[n]);
	}
	
	static class Node implements Comparable<Node>{
		int adj;
		int cow;
		public Node(int adj, int cow) {
			super();
			this.adj = adj;
			this.cow = cow;
		}
		@Override
		public int compareTo(Node o) {
			return this.cow - o.cow;
		}
		@Override
		public String toString() {
			return "Node [adj=" + adj + ", cow=" + cow + "]";
		}
		
		
	}
}