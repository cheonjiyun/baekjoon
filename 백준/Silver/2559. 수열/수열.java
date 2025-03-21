import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim());
		int[] sequence = new int[n];
		for (int i = 0; i < n; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += sequence[i];
		}
		int result = sum;

		for (int i = 0; i < n - k; i++) {
			int left = i;
			int right = i + k;
			sum -= sequence[left];
			sum += sequence[right];

			if (result < sum) {
				result = sum;
			}
		}

		sb.append(result);
		System.out.println(sb);
	}
}
