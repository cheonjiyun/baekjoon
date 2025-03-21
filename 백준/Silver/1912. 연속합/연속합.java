
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int[] sequence = new int[n];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n; i++) {

			sequence[i] = Math.max(sequence[i], sequence[i - 1] + sequence[i]);

		}

		int result = -11111;
		for (int i = 0; i < n; i++) {
			if (result < sequence[i]) {
				result = sequence[i];
			}
		}
		sb.append(result);

		System.out.println(sb);
	}
}
