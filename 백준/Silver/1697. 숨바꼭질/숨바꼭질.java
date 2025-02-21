import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = in.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		System.out.print(bfs(n, k));

//		System.out.println(sb);
	}

	private static int bfs(int n, int k) {
		if (n == k)
			return 0;

		boolean[] visited = new boolean[100001];

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(n);

		int time = 0;
		while (q.size() > 0) {
			time++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				if (cur - 1 == k || cur + 1 == k || cur * 2 == k) {
					return time;
				}

				if (cur - 1 >= 0 && !visited[cur - 1]) {
					q.offer(cur - 1);
					visited[cur - 1] = true;
				}

				if (cur + 1 <= 100000 && !visited[cur + 1]) {
					q.offer(cur + 1);
					visited[cur + 1] = true;
				}

				if (cur * 2 <= 100000 && !visited[cur * 2]) {
					q.offer(cur * 2);
					visited[cur * 2] = true;
				}
			}
		}
		return time;
	}

	// n에서 출발
	// n-1이거나 n+1이거나 2*x로 이동

}