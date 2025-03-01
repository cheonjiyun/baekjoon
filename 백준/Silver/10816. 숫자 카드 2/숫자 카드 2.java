import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim());
		
		HashMap<Integer, Integer> counting = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(st.nextToken());
			
			if(counting.containsKey(number)) {	
				counting.put(number,counting. get(number) + 1);
			}else {
				counting.put(number, 1);		
			}
		}

		st = new StringTokenizer(br.readLine().trim());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < m; i++) {
			int find = Integer.parseInt(st.nextToken());

			if(counting.containsKey(find)) {
				sb.append(counting.get(find));
			}else {
				sb.append(0);
			}
			sb.append(" ");
		}

		System.out.println(sb);
	}
}