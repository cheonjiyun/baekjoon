import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(in.readLine());
			sb.append("#" + test_case + " ");

			String[] input = in.readLine().split(" ");
//			int[] arr = new int[8];
			Queue<Integer> q = new ArrayDeque<>();
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(input[i]));
			}

			boolean can = true;
			while (can) {
				for (int minus = 1; minus <= 5; minus++) {
					int cur = q.poll();

					int num = cur - minus < 0 ? 0 : cur - minus;
					q.offer(num);

					// 0보다 작아지면
					if (num <= 0) {
						can = false;
						break;
					}

				}

			}

			for (int i : q) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}