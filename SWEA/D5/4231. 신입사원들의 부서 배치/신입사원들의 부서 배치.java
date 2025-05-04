import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] employees;
	private static int n;

	static Set<Integer>[] employeeOfDepart;
	private static int[][] deparments;
	private static int[] selectedIndexOfEmpleyee;

	public static void main(String[] args) throws Exception {

	//	System.setIn(new FileInputStream("src/swea신입사원들의부서배치/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			sb.append("\n");
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());

			employees = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					employees[i][j] = Integer.parseInt(st.nextToken()) - 1;
				}
			}

			deparments = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					deparments[i][j] = Integer.parseInt(st.nextToken()) - 1;
				}
			}

			selectedIndexOfEmpleyee = new int[n];
			employeeOfDepart = new HashSet[n];

			// 초기설정
			for (int i = 0; i < n; i++) {
				employeeOfDepart[i] = new HashSet<Integer>();
			}

			for (int i = 0; i < n; i++) {
				// 이 사원이 선택하는 선호
				int index = selectedIndexOfEmpleyee[i];
				int departNum = employees[i][index];
				employeeOfDepart[departNum].add(i);
			}

			boolean conti = true;
			while (conti) {
				conti = false;
				arrangement();
				for (int i = 0; i < n; i++) {
					if (employeeOfDepart[i].size() >= 2) {
						conti = true;
					}
				}
			}

			// 출력
			for (int i = 0; i < n; i++) {
				int index = selectedIndexOfEmpleyee[i];
				int departNum = employees[i][index];
				sb.append(departNum + 1).append("\n");

			}

		}

		System.out.println(sb);
	}

	static void arrangement() {
		Queue<Integer> reSelect = new ArrayDeque<Integer>();
		for (int i = 0; i < n; i++) {
			if (employeeOfDepart[i].size() <= 1) {
				// 2명이상 선택했을 때만
				continue;
			}

			// 부서에서 선호도가 높은 사원
			Set<Integer> seleted = employeeOfDepart[i];
			int max = 0;
			for (int index = 0; index < n; index++) {

				int employ = deparments[i][index];
				if (seleted.contains(employ)) {
					max = employ;
					break;
				}
			}

			// 한명 빼고는 다시 선택해야함.
			for (int employ : seleted) {
				if (employ != max) {
					reSelect.add(employ);
				}
			}

			// 한면만 두고 삭
			employeeOfDepart[i] = new HashSet<Integer>();
			employeeOfDepart[i].add(max);
		}

//		for (int i = 0; i < n; i++) {
//			System.out.println(employeeOfDepart[i]);
//		}
//		System.out.println();

		// 재배
		for (int employ : reSelect) {
			int index = selectedIndexOfEmpleyee[employ];
			index++;
			selectedIndexOfEmpleyee[employ] = index;
			int departNum = employees[employ][index];
			employeeOfDepart[departNum].add(employ);
		}

//		for (int i = 0; i < n; i++) {
//			System.out.println(employeeOfDepart[i]);
//		}
	}
}