import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		arr = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < 8; j++) {
				arr[i][j] = Integer.valueOf(input[j]);
			}
		}

		int k = Integer.valueOf(br.readLine());
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = Integer.valueOf(st.nextToken()) - 1;
			int rotate = Integer.valueOf(st.nextToken());

			int[] rotation = new int[4];
			rotation[index] = rotate;
			for (int j = index -1; j >= 0; j--) {
				if (arr[j][2] != arr[j  + 1][6]) {
					rotation[j] = -rotation[j + 1];
				} else {
					break;
				}
			}

			for (int j = index + 1; j < 4; j++) {
				if (arr[j-1][2] != arr[j][6]) {
					rotation[j] = -rotation[j - 1];
				} else {
					break;
				}
			}

			for (int j = 0; j < 4; j++) {
				if (rotation[j] == 1) {
					moveRight(j);
				} else if (rotation[j] == -1) {
					moveLeft(j);
				}
			}

		}

		int result = 0;
		for (int i = 0; i < 4; i++) {
			if (arr[i][0] == 1) {
				result += Math.pow(2, i);
			}
		}
		sb.append(result);

		System.out.println(sb);
	}

	public static void moveLeft(int index) {
		int first = arr[index][0];
		for (int i = 0; i < 8 - 1; i++) {
			arr[index][i] = arr[index][i + 1];
		}
		arr[index][7] = first;
	}

	public static void moveRight(int index) {
		int last = arr[index][7];
		for (int i = 8 - 1; i >= 1; i--) {
			arr[index][i] = arr[index][i - 1];
		}
		arr[index][0] = last;
	}

}