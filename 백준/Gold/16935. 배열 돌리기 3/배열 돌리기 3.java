
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int m;
	private static int r;
	private static int[][] arr;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine().trim());
		int[] commands = new int[r];
		for (int i = 0; i < r; i++) {
			commands[i] = Integer.parseInt(st.nextToken());
		}

		for (int c = 0; c < r; c++) {
			int command = commands[c];
			if (command == 1) {
				// 상하방전
				command1();
			} else if (command == 2) {
				// 좌우반전
				command2();
			} else if (command == 3) {
				// 오른쪽 90도 회전
				command3();
			} else if (command == 4) {
				// 왼쪽 90도 회전
				command4();
			} else if (command == 5) {
				// 1/4 오른쪽 90도 회전
				command5();
			} else if (command == 6) {
				// 1/4 왼쪽 90도 회전
				command6();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println(sb);
	}

	public static void command1() {
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[n - 1 - i][j];
				arr[n - 1 - i][j] = temp;
			}
		}
	}

	public static void command2() {
		// 좌우반전
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][m - 1 - j];
				arr[i][m - 1 - j] = temp;
			}
		}
	}

	public static void command3() {
		int[][] newArr = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newArr[j][n - 1 - i] = arr[i][j];
			}
		}

		int temp = n;
		n = m;
		m = temp;
		arr = newArr;
	}

	private static void command4() {
		int[][] newArr = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newArr[m - 1 - j][i] = arr[i][j];
			}
		}

		int temp = n;
		n = m;
		m = temp;
		arr = newArr;
	}

	private static void command5() {
		int[][] newArr = new int[n][m];

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				newArr[i][j] = arr[i + n / 2][j];
			}
		}

		for (int i = 0; i < n / 2; i++) {
			for (int j = m / 2; j < m; j++) {
				newArr[i][j] = arr[i][j - m / 2];
			}
		}

		for (int i = n / 2; i < n; i++) {
			for (int j = m / 2; j < m; j++) {
				newArr[i][j] = arr[i - n / 2][j];
			}
		}

		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				newArr[i][j] = arr[i][j + m / 2];
			}
		}

		arr = newArr;
	}

	private static void command6() {
		int[][] newArr = new int[n][m];

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				newArr[i][j] = arr[i][j + m / 2];
			}
		}

		for (int i = 0; i < n / 2; i++) {
			for (int j = m / 2; j < m; j++) {
				newArr[i][j] = arr[n / 2 + i][j];
			}
		}

		for (int i = n / 2; i < n; i++) {
			for (int j = m / 2; j < m; j++) {
				newArr[i][j] = arr[i][j - m / 2];
			}
		}

		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				newArr[i][j] = arr[i - n / 2][j];
			}
		}

		arr = newArr;
	}

}
