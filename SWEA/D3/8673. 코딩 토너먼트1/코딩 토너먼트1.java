import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int result = 0;
			
			int k = sc.nextInt();
			ArrayList<Integer> players = new ArrayList<Integer>();
			for(int i = 0; i < Math.pow(2, k);i ++) {
				players.add(sc.nextInt());
			}

			for(int i = 0; i < k; i++) {				
				ArrayList<Integer> winners = new ArrayList<Integer>();
				for(int j = 0; j < players.size(); j += 2) {
					result += Math.abs(players.get(j) - players.get(j+1));
					winners.add(Math.max(players.get(j), players.get(j+1)));
				}
				
				players = winners;
			}

			System.out.println("#" + test_case + " " + result);
		}
	}
}