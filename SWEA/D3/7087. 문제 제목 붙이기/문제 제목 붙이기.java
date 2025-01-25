
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			ArrayList<Character> titles = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				titles.add(sc.next().charAt(0)); // 첫번째 문자만 저장
			}
			Collections.sort(titles);// 정렬

			int result = 0;
			char compareCurrent = 'A';
			for (int i = 0; i < n; i++) { // 두번째부터 비교
				if (compareCurrent == titles.get(i)) {
					result += 1;
					compareCurrent += 1;
				}
			}

			System.out.println("#" + test_case + " " + result);
		}
	}
}