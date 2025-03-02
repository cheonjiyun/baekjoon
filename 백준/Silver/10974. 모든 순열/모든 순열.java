import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());

		permutation(1, new int[n+1], new boolean[n+1]);

		System.out.println(sb);
	}
	
	static public void permutation(int cnt, int[] numbers, boolean[] visited) {
		if(cnt == n + 1) {
			for(int i = 1; i <= n; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if(visited[i]) continue;
			numbers[cnt] = i;
			visited[i] = true;
			permutation(cnt + 1, numbers, visited);
			visited[i] = false;
		}
	}
}