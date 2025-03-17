import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	static BigInteger[] fac;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			fac = new BigInteger[Math.max(n, m) + 1];
			sb.append(combination(Math.max(n, m), Math.min(n, m))).append("\n");
		}

		System.out.println(sb);
	}

	public static BigInteger combination(int n, int r) {
		if (r == 0 || n == r) {
			return BigInteger.ONE;
		}
		// n!
		// (n - r)! / r!;
		return (factorial(n).divide(factorial(n - r))).divide(factorial(r));
	}

	public static BigInteger factorial(int n) {
		if (fac[n] == null) {
			if (n == 0) {
				fac[n] = BigInteger.ONE;
			} else {
				fac[n] = BigInteger.valueOf(n).multiply(factorial(n - 1));
			}
		}
		return fac[n];
	}
}
