import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] parent;

	public static void main(String[] args) throws Exception {

		// System.in(new FileInputStream("src/집합의표현/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (command == 0) {
				// union
				union(a, b);
			} else {
				// find
				if (find(a, b)) {
					sb.append("YES");
				} else {
					sb.append("NO");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}

	static void union(int a, int b) {
		int rootA = findRoot(a);
		int rootB = findRoot(b);
		if(rootA != rootB) {
			parent[rootA] = rootB;
		}
	}
	static int findRoot(int x) {
		if(parent[x] == x) {
			return x;
		}else {
			parent[x] = findRoot(parent[x]); // 압
			return parent[x];
		}
	}

	static boolean find(int a, int b) {
		return findRoot(a) == findRoot(b);
	}

}