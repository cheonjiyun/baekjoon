import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String[] input = in.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		// 필요한 변수
		int[] enterEdgeCount = new int[N + 1]; // 진입차수
		List<List<Integer>> graph = new ArrayList<List<Integer>>(); // i번째 보다 큰 사람

		// 큰지작은지입력
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			String[] inputs = in.readLine().split(" ");
			int A = Integer.parseInt(inputs[0]);
			int B = Integer.parseInt(inputs[1]);
			graph.get(A).add(B);
			enterEdgeCount[B] += 1;
		}

		// 위상정렬 큐
		Queue<Integer> q = new LinkedList<>();

		// 진입차수가 0인 사람 찾기 (초기)
		for (int i = 1; i <= N; i++) {
			if (enterEdgeCount[i] == 0) {
				q.add(i);
			}
		}

		List<Integer> result = new ArrayList<>();

		// 큐가 빌때까지
		while (q.size() > 0) {
			int curPersonNum = q.poll(); // 큐 꺼내기

			result.add(curPersonNum); // 작은 사람 줄 세우기

			for (int outPersonNum : graph.get(curPersonNum)) { // 이 사람보다 큰 사람들

				enterEdgeCount[outPersonNum] -= 1; // 진입차수 -1

				// 진입차수가 0이면 q에 추가
				if (enterEdgeCount[outPersonNum] == 0) {
					q.add(outPersonNum);
				}
			}
		}

		for (int num : result) {
			sb.append(num).append(" ");
		}

		System.out.println(sb);
	}
}