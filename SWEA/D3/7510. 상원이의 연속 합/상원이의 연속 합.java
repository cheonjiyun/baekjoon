import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("src/swea상원이의연속합/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			long n = Integer.valueOf(br.readLine());
			
			int result = 0; 
			for(int i = 1; i <= n; i++) {
				int sum = 0;
				for(int j = i; j <= n; j++) {
					sum += j;
					if(sum == n) {
						result++;
						break;
					}else if(sum > n) {
						break;
					}
				}
			}
			sb.append(result).append("\n");

		}

		System.out.println(sb);
	}
}