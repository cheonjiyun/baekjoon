import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static long INF = 4999500;
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Edge> edgeList = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edgeList.add(new Edge(a, b, c));
		}

		long[] dist = new long[n + 1];
		Arrays.fill(dist, INF);
		dist[1] = 0; // 시작지점
		
		boolean cycle = false;

		for (int i = 0; i < n; i++) {
			for (Edge edge : edgeList) {
				// 이 간선을 거쳐가는 경우
				if (dist[edge.end] > dist[edge.start] + edge.time) {
					
					// 못가는 경우
					if(dist[edge.start] == INF || edge.time == INF) continue;
					
					dist[edge.end] = dist[edge.start] + edge.time;
					
					// n번쨰에도 생긴다면
					if(i == n-1) {
						cycle = true;
					}
				}
				
			}
		}
		
		if(cycle) {
			sb.append(-1);
		}else {

			for (int i = 2; i <= n; i++) {
				sb.append(dist[i] == INF ? -1 : dist[i]).append("\n");
			}
			
		}

		System.out.println(sb);
	}

	static class Edge {
		int start;
		int end;
		int time;

		public Edge(int start, int end, int time) {
			super();
			this.start = start;
			this.end = end;
			this.time = time;
		}
	}
}
