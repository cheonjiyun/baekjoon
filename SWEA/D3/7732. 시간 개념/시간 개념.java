import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {

		//System.setIn(new FileInputStream("src/swea시간개념/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			String[] current = br.readLine().split(":");
			String[] next = br.readLine().split(":");

			int curSec = Integer.parseInt(current[0]) * 3600 + Integer.parseInt(current[1]) * 60
					+ Integer.parseInt(current[2]);
			int nextSec = Integer.parseInt(next[0]) * 3600 + Integer.parseInt(next[1]) * 60 + Integer.parseInt(next[2]);

			int remainSec = nextSec - curSec;
			if (remainSec <= 0) {
				remainSec += 24 * 60 * 60;
			}

			int hour = remainSec / 3600;
			remainSec %= 3600;
			int minute = remainSec / 60;
			remainSec %= 60;
			int second = remainSec;

			sb.append(String.format("%02d:%02d:%02d\n", hour, minute, second));

		}

		System.out.println(sb);
	}
}