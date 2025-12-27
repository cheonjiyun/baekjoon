import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
	
	static ArrayList<Edge>[] edgeList;
	
	static long max = 10_000_000_000L;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken()); 
		int k = Integer.parseInt(st.nextToken()); 
		
		edgeList = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) {
			edgeList[i] = new ArrayList<Edge>();
		}
	
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			int w = Integer.parseInt(st.nextToken()); 
			
			edgeList[a].add(new Edge(b, w));
			edgeList[b].add(new Edge(a, w));
		}
		
		Queue<Node> pq = new PriorityQueue<>();
		long[][] distance = new long[n+1][k+1];
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j <k+1; j++) {
				distance[i][j] = max;
				if(i == 1) { // 시작
					distance[i][j] = 0;
				}
			}
		}
		pq.offer(new Node(1, 0, 0));
		
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(distance[cur.idx][cur.pave] < cur.time) {
				continue;
			}
			
			for(Edge edge : edgeList[cur.idx]) {
				
				if(cur.pave+1 <=k && distance[edge.dest][cur.pave+1] > cur.time) { // 도로포장
					pq.offer(new Node(edge.dest, cur.time, cur.pave + 1));
					distance[edge.dest][cur.pave + 1] = cur.time;
				}
				if(distance[edge.dest][cur.pave] > cur.time + edge.weight) {
					pq.offer(new Node(edge.dest, cur.time + edge.weight, cur.pave));
					distance[edge.dest][cur.pave] = cur.time + edge.weight;
					
				}
			}
		}
		
		long result = max;
		for(int i = 0; i < k+1; i++) {
			result = Math.min(result, distance[n][i]);
		}

		System.out.println(result);
			
	}
	
	static class Node implements Comparable<Node>{
		int idx;
		long time;
		int pave;
		
		public Node(int idx, long time, int pave) {
			this.idx = idx;
			this.time = time;
			this.pave = pave;
		}

		@Override
		public int compareTo(Main.Node o) {
			return Long.compare(this.time, o.time);
		}
	}
	
	static class Edge{
		int dest;
		long weight;
		
		public Edge(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
		
	}
}