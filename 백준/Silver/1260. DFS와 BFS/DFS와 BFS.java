import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int n;
	static int[][] list;
	static boolean[] visitedd;
	static boolean[] visitedb;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = in.readLine().split(" ");

		n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int v = Integer.parseInt(input[2]);

		list = new int[n + 1][n + 1];
		visitedd = new boolean[n + 1];
		visitedb = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			String[] inputs = in.readLine().split(" ");
			int a = Integer.parseInt(inputs[0]);
			int b = Integer.parseInt(inputs[1]);

			list[a][b] = list[b][a] = 1;
		}

		bfs(v);
		System.out.println();
		dfs(v);

	}

	private static void bfs(int v) {
		System.out.print(v + " ");
		visitedb[v] = true;
		for (int i = 1; i <= n; i++) {
			if (list[i][v] == 1) {
				if (visitedb[i])
					continue;

				bfs(i);
			}
		}
	}

	private static void dfs(int v) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(v);

		visitedd[v] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");

			for (int i = 1; i <= n; i++) {
				if (list[cur][i] == 1) {
					if (visitedd[i])
						continue;

					visitedd[i] = true;
					q.offer(i);
				}

			}
		}

	}
}