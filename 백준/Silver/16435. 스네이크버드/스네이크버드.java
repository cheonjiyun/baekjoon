

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] fruits = new int[n];
		boolean[] eat = new boolean[n];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			fruits[i] = value;
			
			if(value <= l) {
				eat[i] = true;
				l += 1;
			}
		}
		
		boolean has;
		while(true) {
			has = false;
			for(int i = 0; i < n; i++) { // 한바퀴 돌면서 작은 아이가 있는지
				if(fruits[i] <= l && eat[i] == false) {
					eat[i] = true;
					l += 1;
					has= true;
				}
			}
			if(has == false) {// 한바퀴 돌았는데도 못먹었으면
				break;
			}
		}
		
		sb.append(l);
		

		System.out.println(sb);
	}
}
