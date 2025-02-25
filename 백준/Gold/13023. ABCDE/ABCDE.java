import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] inputs = in.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		List<ArrayList<Integer>> friends = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			friends.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			String[] input2 = in.readLine().split(" ");
			int a = Integer.parseInt(input2[0]);
			int b = Integer.parseInt(input2[1]);

			friends.get(a).add(b);
			friends.get(b).add(a);
		}

		int result = dfs(n, friends) ? 1 : 0;

		sb.append(result);
		System.out.println(sb);
	}

	public static boolean dfs(int n, List<ArrayList<Integer>> friends) {
		// 모든 사람을 시작점으로 돔
		for (int start = 0; start < n; start++) {
			boolean[] visited = new boolean[n];
			if (dfs(start, friends, visited, 1)) {
				return true;
			}
		}
		return false;
	}

	public static boolean dfs(int start, List<ArrayList<Integer>> friends, boolean[] visited, int depth) {
		if (depth == 5)
			return true;

		visited[start] = true; // 이번 방문 추가

		for (int next : friends.get(start)) {
			// 본인과 친구라면
			if (visited[next] == false) {
				if (dfs(next, friends, visited, depth + 1)) {
					return true;
				}
			}
		}
		
		visited[start] = false;
		return false;
	}
}