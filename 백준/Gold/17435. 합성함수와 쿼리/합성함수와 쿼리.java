

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	final static int log = (int) (Math.log(500000) / Math.log(2));

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim());
		int[][] fn = new int[log + 1][m + 1];
		for (int i = 1; i <= m; i++) {
			fn[0][i] = Integer.parseInt(st.nextToken());
		}

		// 0 1 2 3 4
		// 1 2 4 8 16
		for (int i =1; i <= log; i++) {
			for (int j = 1; j <= m; j++) {
				int x = fn[i - 1][j]; // sqrt(i)까지 구해져있음
				fn[i][j] = fn[i - 1][x]; // fsqrt(fsqrt(x));
			}
		}

		st = new StringTokenizer(br.readLine().trim());
		int q = Integer.parseInt(st.nextToken());
		for (int t = 0; t < q; t++) {
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			for (int b = log; b > -1; b--) {
				int bit = (1 << b); // 1000 앞부터 2의 제곱수
				if (n >= bit) {
					n -= bit;
					x = fn[b][x]; // x 업데이트
					if (n == 0)
						break;
				}
			}


			sb.append(x).append("\n");

		}


		System.out.println(sb);
	}
};