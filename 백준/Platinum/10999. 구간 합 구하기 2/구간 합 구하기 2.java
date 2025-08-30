import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static long[] segmentTree;
	private static int LEN;
	private static long[] lazy;

	static void propagate(int start, int end, int idx) {
		if (lazy[idx] != 0) { // lazy적립된게 있다뎜
			segmentTree[idx] += lazy[idx] * (end - start + 1); // lazy를 반영

			if (end - start != 0) { // leaf가 아닐 때만
				// lazy를 자식에게 내림
				lazy[idx * 2] += lazy[idx];
				lazy[idx * 2 + 1] += lazy[idx];

			}

			// 초기화
			lazy[idx] = 0;
		}
	}

	// lazy를 업데이트
	static void update(int start, int end, Long addValue, int s, int e, int idx) {

		propagate(s, e, idx);

		if (e < start || end < s)
			return;

		if (s >= start && end >= e) { // 구간에 처음 당첨될 때 lazy등록
			lazy[idx] += addValue;
			propagate(s, e, idx); // 바로 반영
			return;
		}

		// 구간에 맞을 때 까지 밑으로 내려감
		int mid = (s + e) / 2;

		update(start, end, addValue, s, mid, idx * 2);
		update(start, end, addValue, mid + 1, e, idx * 2 + 1);

		// 이제서야 진짜 값 갱신
		segmentTree[idx] = segmentTree[idx * 2] + segmentTree[idx * 2 + 1];

	}

	static long getSum(int start, int end, int s, int e, int idx) {
		propagate(s, e, idx); // 값을 구하기 전에 lazy까지 다 반영되었는지 확인

		if (e < start || end < s) {
			return 0;
		}

		if (s >= start && end >= e) {
			return segmentTree[idx];
		}

		int mid = (s + e) / 2;
		return getSum(start, end, s, mid, idx * 2) + getSum(start, end, mid + 1, e, idx * 2 + 1);
	}

	static void initUpdate() {
		for (int i = LEN - 1; i >= 1; i--) {
			segmentTree[i] = segmentTree[i * 2] + segmentTree[i * 2 + 1];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		LEN = 1;
		while (LEN < n) {
			LEN *= 2;
		}

		int SIZE = 2 * LEN;

		segmentTree = new long[SIZE];
		lazy = new long[SIZE];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			segmentTree[i + LEN] = Long.parseLong(st.nextToken());
		}

		initUpdate();

		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());

			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				Long d = Long.parseLong(st.nextToken());
				update(b, c, d, 1, LEN, 1);
			} else if (a == 2) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				long result = getSum(b, c, 1, LEN, 1);
				sb.append(result).append("\n");
			}
		}
		System.out.println(sb);

	}
}