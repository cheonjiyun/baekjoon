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

		int[] numbers = new int[n];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(numbers);

		st = new StringTokenizer(br.readLine().trim());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < m; i++) {
			int find = Integer.parseInt(st.nextToken());

			// 이분탐색
			sb.append(binarySearch(numbers, find)).append("\n");
		}

		System.out.println(sb);
	}

	static int binarySearch(int[] numbers, int find) {
		int left = 0;
		int right = numbers.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (numbers[mid] == find) {
				return 1;
			}

			else if (numbers[mid] < find) {
				left = mid + 1;

			} else if (find < numbers[mid]) {
				right = mid - 1;
			}

		}
		return 0;
	}
}