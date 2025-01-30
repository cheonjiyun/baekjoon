
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
			for(int i = 1; i <= n; i++) {
				for(int j =1; j <= m; j++) {
					if(frequency.containsKey(i+j)) {
						frequency.put(i + j,  frequency.get(i+j) + 1);	
					}else {
						frequency.put(i + j, 1);						
					}
				}
			}
			
			int maxValue = Collections.max(frequency.values());
			ArrayList<String> result = new ArrayList<String>();
			for(int k : frequency.keySet()) {
				if(frequency.get(k) == maxValue) {
					result.add(String.valueOf(k));
				}
			}
			
			System.out.println("#" + test_case + " " + String.join(" ",result));
		} 
	}
}