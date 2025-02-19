import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[][] ingredients;
	static int result = Integer.MAX_VALUE;

	public static void subSet(int idx, int acidity, int acerbity) {
		if (idx == N) {
			if (acidity == 1 && acerbity == 0)
				return; // 초기값이면 무시

			int diff = Math.abs(acidity - acerbity);
			if (diff < result)
				result = diff;
			return;
		}

//		isSelect[idx] = true;
		subSet(idx + 1, acidity * ingredients[idx][0], acerbity + ingredients[idx][1]);

//		isSelect[idx] =false;
		subSet(idx + 1, acidity, acerbity);
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());

		ingredients = new int[N][2];

		for (int i = 0; i < N; i++) {
			String[] input = in.readLine().split(" ");

			ingredients[i][0] = Integer.parseInt(input[0]);
			ingredients[i][1] = Integer.parseInt(input[1]);
		}

		subSet(0, 1, 0);

		sb.append(result);

		System.out.println(sb);
	}

}