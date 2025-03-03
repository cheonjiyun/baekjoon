import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int t = Integer.parseInt(st.nextToken());

		List<String> colorCircle =Arrays.asList( "red", "orange", "yellow", "green", "blue", "purple" );

		for (int testCase = 0; testCase < t; testCase++) {
			st = new StringTokenizer(br.readLine().trim());
			String a = st.nextToken();
			String b = st.nextToken();
			
			int idx1 = colorCircle.indexOf(a);
			int idx2 = colorCircle.indexOf(b);

			int idx2Left = (idx2 + 6 -1) % 6;
			int idx2Right = (idx2 + 6 +1) % 6;
			

			int idx2Left3 = (idx2 + 6 -3) % 6;
			int idx2Right3 = (idx2 + 6 +3) % 6;
			
			if(idx1 == idx2) {
				System.out.println("E");
			}else if(idx2Left == idx1 || idx2Right == idx1) {
				System.out.println("A");
			}else if(idx2Left3 == idx1 || idx2Right3 == idx1) {
				System.out.println("C");
			}else {
				System.out.println("X");
			}
				
		}
	}
}