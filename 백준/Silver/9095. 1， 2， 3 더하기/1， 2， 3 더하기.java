import java.io.BufferedReader;
import java.io.InputStreamReader;
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

			sb.append(permutation(n)).append("\n");
		}

		System.out.println(sb);
	}

	static public int permutation(int num) {
		if (num == 1) {
			// 1
			return 1;
		} else if (num == 2) {
			// 1 + 1
			// 2
			return 2;
		} else if (num == 3) {
			// 1 + 1 + 1
			// 2 + 1
			// 1 + 2
			// 3
			return 4;
		}
		else {
			return permutation(num - 1)  + permutation(num - 2) + permutation(num - 3);
		}
	}
}