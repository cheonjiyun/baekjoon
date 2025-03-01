import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());

		int[][] numbers = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			numbers[i][0] = Integer.parseInt(st.nextToken());
			numbers[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}

		});

		for (int i = 0; i < n; i++) {
			sb.append(numbers[i][0]).append(" ").append(numbers[i][1]).append("\n");
		}

		System.out.println(sb);
	}
}