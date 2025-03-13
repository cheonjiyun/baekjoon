
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static boolean visited[][];
	static char[][] arr;
	static int n;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());

		arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());

			arr[i] = st.nextToken().toCharArray();
		}

		visited = new boolean[n][n];

		int result = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (visited[i][j])
					continue;

				visited[i][j] = true;
				dfs(i, j);
				result++;
			}
		}


		sb.append(result).append(" ");
		
		
		// 변경
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j] == 'R') {
					arr[i][j] = 'G';
				}
			}
		}
		
		result = 0;
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j])
					continue;

				visited[i][j] = true;
				dfs(i, j);
				result++;
			}
		}

		sb.append(result);

		System.out.println(sb);
	}

	private static void dfs(int i, int j) {
		for (int d = 0; d < 4; d++) {
			int nx = dx[d] + i;
			int ny = dy[d] + j;

			if (nx < 0 || ny < 0 || nx >= n || ny >= n)
				continue;

			if (visited[nx][ny])
				continue;

			if (arr[i][j] != arr[nx][ny])
				continue;

			visited[nx][ny] = true;

			dfs(nx, ny);
		}
	}

}
