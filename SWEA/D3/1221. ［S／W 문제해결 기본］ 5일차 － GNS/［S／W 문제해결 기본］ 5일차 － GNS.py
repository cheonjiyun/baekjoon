
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {

	static HashMap<String, Integer> numberMap = new HashMap<>();
	static String[] stringArr = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };

	public static void main(String[] args) throws Exception {

		numberMap.put("ZRO", 0);
		numberMap.put("ONE", 1);
		numberMap.put("TWO", 2);
		numberMap.put("THR", 3);
		numberMap.put("FOR", 4);
		numberMap.put("FIV", 5);
		numberMap.put("SIX", 6);
		numberMap.put("SVN", 7);
		numberMap.put("EGT", 8);
		numberMap.put("NIN", 9);

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine().trim());
			sb.append(st.nextToken()).append(" " );
			int n = Integer.parseInt(st.nextToken());

			int[] numInt = new int[n];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < n; i++) {
				numInt[i] = numberMap.get(st.nextToken());
			}

			Arrays.sort(numInt);

			for (int i = 0; i < n; i++) {
				sb.append(stringArr[numInt[i]]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
