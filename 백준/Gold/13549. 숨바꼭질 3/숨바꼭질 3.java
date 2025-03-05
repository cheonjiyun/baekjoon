import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		sb.append(dijstra(n, k));
		System.out.println(sb);
	}

	public static int dijstra(int start, int end) {
		Queue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0));

		int[] time = new int[100001];
		Arrays.fill(time, 10000000);
		time[start] = 0;
		boolean[] visited = new boolean[100001];

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.location])
				continue;			
			visited[cur.location] = true;
			
			time[cur.location] = cur.time;

			if (cur.location == end)
				break;			

			if (cur.location - 1 >= 0 && cur.location - 1 < 100001) {
				pq.offer(new Node(cur.location - 1, cur.time + 1));
			}
			if (cur.location + 1 >= 0 && cur.location + 1 < 100001) {
				pq.offer(new Node(cur.location + 1, cur.time + 1));
			}
			if (cur.location * 2 >= 0 && cur.location * 2 < 100001) {
				pq.offer(new Node(cur.location * 2, cur.time));
			}
		}

		return time[end];

	}

	static class Node implements Comparable<Node> {
		int location;
		int time;

		public Node(int location, int time) {
			super();
			this.location = location;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}

		@Override
		public String toString() {
			return "Node [location=" + location + ", time=" + time + "]";
		}
	}
}
