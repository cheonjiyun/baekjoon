import java.util.*;
import java.io.*;

public class Solution {
	private static final int SIZE = 100;
	private static int[][] map = new int[SIZE][SIZE];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");

			int N = Integer.parseInt(br.readLine());

			for (int i = 0; i < SIZE; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < SIZE; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append(findMaxSum()).append("\n");
		}

		System.out.println(sb);
	}

	private static int findMaxSum() {
		int maxSum = 0;
		int diagonalSum = 0, antiDiagonalSum = 0;

		for (int i = 0; i < SIZE; i++) {
			int rowSum = 0, colSum = 0;
			for (int j = 0; j < SIZE; j++) {
				rowSum += map[i][j];
				colSum += map[j][i];
			}
			diagonalSum += map[i][i];
			antiDiagonalSum += map[i][SIZE - i - 1];
			maxSum = Math.max(maxSum, Math.max(rowSum, colSum));
		}
		return Math.max(maxSum, Math.max(diagonalSum, antiDiagonalSum));
	}
}