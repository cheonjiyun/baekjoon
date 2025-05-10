import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("src/swea_문제이름/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] board = new int[101];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			board[x] = y;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			board[u] = v;
		}

		Queue<Node> q = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.time - o2.time;
			}
		});
		q.offer(new Node(1, 0));
		boolean[] visited = new boolean[101];

		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			if(visited[cur.kan]) {
				continue;
			}
			visited[cur.kan] = true;		
			
			if (cur.kan == 100) {
				sb.append(cur.time);
				break;
			}

			if (board[cur.kan] != 0) {
					q.offer(new Node(board[cur.kan], cur.time));					
				
			} else {

				for (int i = 1; i <= 6; i++) {
					if (cur.kan + i <= 100) {
							q.offer(new Node(cur.kan + i, cur.time + 1));							
					
					}
				}
			}
		}

		System.out.println(sb);
	}

	static class Node {
		int kan;
		int time;

		public Node(int kan, int time) {
			super();
			this.kan = kan;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Node [kan=" + kan + ", time=" + time + "]";
		}

	}

}