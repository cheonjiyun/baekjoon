import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static boolean[] visited;
	private static ArrayDeque<Node> q;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("src/swea_문제이름/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine().trim());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			


			sb.append(bfs(A, B));
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static String bfs(int before, int after) {
		q = new ArrayDeque<Main.Node>();
		q.offer(new Node(before, ""));
		visited = new boolean[10001];

		String result = "";
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if(visited[cur.current]) {
				continue;
			}
			visited[cur.current] = true;

			if (cur.current == after) {
				result = cur.memo;
				break;
			}

			q.offer(new Node((cur.current * 2) % 10000, cur.memo + "D")); // D
			q.offer(new Node(cur.current - 1 < 0 ? 9999 : cur.current - 1, cur.memo + "S")); // S

			int a = cur.current / 1000;
			int b = (cur.current % 1000) / 100;
			int c = (cur.current % 100) / 10;
			int d = cur.current % 10;

			q.offer(new Node(b * 1000 + c * 100 + d * 10 + a, cur.memo + "L")); // L
			q.offer(new Node(d * 1000 + a * 100 + b * 10 + c, cur.memo + "R")); // R
		}
		return result;
	}

	static class Node {
		int current;
		String memo;

		public Node(int current, String memo) {
			super();
			this.current = current;
			this.memo = memo;
		}

		@Override
		public String toString() {
			return "Node [current=" + current + ", memo=" + memo + "]";
		}

	}
}
