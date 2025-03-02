import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] dp;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		dp = new int[n+1];
		Arrays.fill(dp, -1);
		dp[1]= 0;

		sb.append(makeone(n));
		System.out.println(sb);
	}

	static public int makeone(int num) {

		if (dp[num] == -1) {	
			int min = Integer.MAX_VALUE;

			if (num % 3 == 0) {
				min = Math.min(min, makeone(num / 3));
			}

			if (num % 2 == 0) {
				min = Math.min(min, makeone(num / 2));
			}

			min = Math.min(min, makeone(num - 1));
			
			dp[num] = min+1;
		}

		return dp[num];
	}
}