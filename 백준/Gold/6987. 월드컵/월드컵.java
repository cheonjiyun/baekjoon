import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//	static int[][] matchCase = new int[6][3];
	static int[][] result;
	static boolean can;
	static StringBuilder sb = new StringBuilder();;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
			can = false;
			result = new int[6][3];
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 6; j++) {
				int win = Integer.parseInt(st.nextToken());
				int draw = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());

				result[j][0] = win;
				result[j][1] = draw;
				result[j][2] = lose;
			}

			matchComb(0, 1);

			if (can) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}
		}

		System.out.println(sb);
	}

	public static void matchComb(int rTeam, int cTeam) {

		if (cTeam == 6) {
			rTeam++;
			cTeam = rTeam + 1;
		}

		if (rTeam == 5) {

			boolean flag = true;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (result[i][j] != 0) {
						flag = false;
					}
				}
			}
			if (flag)
				can = true;

			return;
		}

		// start가 승리
		result[rTeam][0] -= 1;
		result[cTeam][2] -= 1;
		if (result[rTeam][0] >= 0 && result[cTeam][2] >= 0) {
			matchComb(rTeam, cTeam + 1); //// 다음경기
		}
		result[rTeam][0] += 1;
		result[cTeam][2] += 1;

		// 무
		result[rTeam][1] -= 1;
		result[cTeam][1] -= 1;
		if (result[rTeam][1] >= 0 && result[cTeam][1] >= 0) {
			matchComb(rTeam, cTeam + 1);
		}
		result[rTeam][1] += 1;
		result[cTeam][1] += 1;

		// 패
		result[rTeam][2] -= 1;
		result[cTeam][0] -= 1;
		if (result[rTeam][2] >= 0 && result[cTeam][0] >= 0) {
			matchComb(rTeam, cTeam + 1);
		}

		result[rTeam][2] += 1;
		result[cTeam][0] += 1;

	}
}
