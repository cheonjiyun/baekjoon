

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();

		int tLength = T.length;
		int pLength = P.length;

		int[] next = new int[pLength];
		for (int i = 1, j = 0; i < pLength; i++) {
			while (j > 0 && P[i] != P[j]) {
				j = next[j - 1];
			}

			if (P[i] == P[j]) {
				next[i] = ++j;
			} else {
				next[i] = 0;
			}
		}

		int cnt = 0;
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0, j = 0; i < tLength; i++) {
			while (j > 0 && T[i] != P[j]) {
				j = next[j - 1];
			}

			if (T[i] == P[j]) {
				if (j == pLength - 1) {
					cnt++;
					list.add(i - (pLength - 1) + 1);

					j = next[j];
				} else {
					j++;
				}
			}
		}

		sb.append(cnt).append("\n");
		if (cnt > 0) {
			for (int el : list) {
				sb.append(el).append(" ");

			}
		}

		System.out.println(sb);
	}
}
