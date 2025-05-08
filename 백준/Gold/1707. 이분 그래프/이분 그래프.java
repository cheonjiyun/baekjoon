import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<ArrayList<Integer>> adjList;
	private static String result;
	private static int[] color;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("src/swea_문제이름/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int k = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= k; test_case++) {

			st = new StringTokenizer(br.readLine().trim());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			adjList = new ArrayList<ArrayList<Integer>>();
			for(int i = 0; i <= v ; i++) {
				adjList.add(new ArrayList<>());
			}
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int u1 = Integer.parseInt(st.nextToken());
				int u2 = Integer.parseInt(st.nextToken());
				
				adjList.get(u1).add(u2);
				adjList.get(u2).add(u1);
			}

			result = "YES";
			color = new int[v+1];
			for(int i = 1 ; i <= v ;i++) {
				if(color[i] == 0 && result.equals("YES")) {					
					bfs(i);
				}
			}

			sb.append(result);
			sb.append("\n");
		}

		System.out.println(sb);
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		q.offer(start);
		color[start] = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int adj : adjList.get(cur)) {
				if(color[adj] == color[cur]) {
					result= "NO";
					return;
				}
				if(color[adj] != 0) {
					continue;
				}
				
				color[adj] = color[cur] * -1;
				q.offer(adj);
			}				
		}
		
	}
}