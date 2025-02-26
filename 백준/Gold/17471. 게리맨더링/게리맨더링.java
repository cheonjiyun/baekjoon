import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<ArrayList<Integer>> adjacency;
	static int[] population;
	static int result;

	public static void main(String[] args) throws Exception {
		result = -1;

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		population = new int[n + 1];
		for (int i = 0; i < n; i++) {
			population[i + 1] = Integer.parseInt(st.nextToken());
		}

		adjacency = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= n; i++) {
			adjacency.add(new ArrayList<>());
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				adjacency.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		// 둘 중 하나 선택해햐 함
		// 선거구끼리는 연결되어있어야 함
		// 두 선거구는 연결되어있음

		// 1. 둘 중 하나로 일단 선택해 2*n
		bitmasking(n);
		// 2. 서로소 집합으로 구역 나누기

		// 3. 두개로 나뉘는지 확인

		// 4. 차이가 최소 인 값 확인

		sb.append(result);

		System.out.println(sb);
	}

	static int[] district;
	static int[] parents;

	static void makeSet(int n) {
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}

	// 비트마스킹으로 모든 경우 해본다.
	static void bitmasking(int n) {

		district = new int[n + 1];
		parents = new int[n + 1];
		for (int i = 0; i < Math.pow(2, n); i++) {
			Arrays.fill(district, 0);
			makeSet(n);

			int number = i;

			for (int j = 0; j < n; j++) {
				int bit = 1 << j;
				if ((number & bit) != 0) { // on 되어있는 곳에
					district[n - j] = 1;
				}
			}
			// 선택 끝
//			System.out.println(Arrays.toString(district));

			// 2. 서로소 집합으로 구역 나누기
			div(district, n);
//			System.out.println("parents : " + Arrays.toString(parents));

			// 3. 두개로 나뉘는지 확인
			HashSet<Integer> count = new HashSet<>();
			for (int ad = 1; ad <= n; ad++) {
				count.add(findSet(ad));
			}

//			System.out.println("count : " + count);
			// 4. 차이가 최소 인 값 확인
			int[] populationSum = new int[2];
			if (count.size() == 2) {
				for (int ad = 1; ad <= n; ad++) {
					populationSum[district[ad]] += population[ad];
				}				

				int dist = Math.abs(populationSum[0] - populationSum[1]);
//				System.out.println("dist : " + dist);
				
				if(result == -1) {
					result = dist;
				}else {
					result = Math.min(result, dist);					
				}
			}


		}
	}

	private static void div(int[] district, int n) {
		for (int i = 1; i <= n; i++) {
			for (int adj : adjacency.get(i)) {
				if (district[i] == district[adj]) { // 구역이 같다면
					union(i, adj);
				}
			}
		}
	}

	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot) {
			return false;
		}

		parents[bRoot] = aRoot;
		return true;
	}

	private static int findSet(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}
}