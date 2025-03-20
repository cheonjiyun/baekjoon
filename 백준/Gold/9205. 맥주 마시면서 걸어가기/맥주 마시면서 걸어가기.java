
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());


			int[][] matrix = new int[n+1][2];
			for (int i = 0; i <= n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				matrix[i][0] = Integer.parseInt(st.nextToken());
				matrix[i][1] = Integer.parseInt(st.nextToken());
			}

			int[] festival = new int[2];
			st = new StringTokenizer(br.readLine().trim());
			festival[0] = Integer.parseInt(st.nextToken());
			festival[1] = Integer.parseInt(st.nextToken());

			Queue<Integer> q = new ArrayDeque<>();
			q.offer(0);

			boolean[] visited = new boolean[n+1];

			String result = "sad";
			while (!q.isEmpty()) {
				int curIdx = q.poll();

				if (visited[curIdx])
					continue;
				visited[curIdx] = true;

				int[] current = matrix[curIdx];

				if (canGo(current[0], current[1], festival[0], festival[1])) {
					result = "happy";
					break; // 이 편의점에서 페스티펄로 갈 수 있다.
				}
				
				for (int nextIdx = 1; nextIdx <= n; nextIdx++) {

					int[] nextConvience = matrix[nextIdx];

					if (canGo(current[0], current[1], nextConvience[0], nextConvience[1])) {
						q.offer(nextIdx);
					}
				}
			}

			sb.append(result).append("\n");

		}

		System.out.println(sb);
	}

	static boolean canGo(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2) <= 20 * 50;
	}
}
