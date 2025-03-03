import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int win;
	static int lose;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int T = Integer.parseInt(st.nextToken());

		for (int testCase = 1; testCase <= T; testCase++) {
			win = 0;
			lose = 0;
			sb.append("#" + testCase + " ");

			int[] cardInfo = new int[19]; // 1 : 규영, // 2: 인영
			int[] gueCard = new int[9];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < 9; i++) {
				int value = Integer.parseInt(st.nextToken());
				cardInfo[value] = 1;
				gueCard[i] = value;
			}
//			System.out.println(Arrays.toString(cardInfo));
			permutation(0, cardInfo, gueCard, new int[9]);

			sb.append(win).append(" ").append(lose).append("\n");
		}

		System.out.println(sb);
	}

	static public void permutation(int cnt, int[] cardInfo, int[] gueCard, int[] gueIn) {
		if (cnt == 9) {

			int scoreGue = 0;
			int scoreIn = 0;

			for (int i = 0; i < 9; i++) {
				if (gueCard[i] > gueIn[i]) {
					scoreGue += gueCard[i] + gueIn[i];
				} else {
					scoreIn += gueCard[i] + gueIn[i];
				}
			}

			if (scoreGue > scoreIn) {
				win += 1;
			} else {
				lose += 1;
			}

//			System.out.println(Arrays.toString(gueCard));
//			System.out.println(Arrays.toString(gueIn));
//			System.out.println("scoreGue :" + scoreGue + " scoreIn: " + scoreIn);
			return;
		}

		for (int num = 1; num <= 18; num++) {
			if (cardInfo[num] == 0) {
				cardInfo[num] = 2;
				gueIn[cnt] = num;
				permutation(cnt + 1, cardInfo, gueCard, gueIn);
				cardInfo[num] = 0;
			}
		}
	}
}