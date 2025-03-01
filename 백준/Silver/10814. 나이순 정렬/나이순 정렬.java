import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("테스트케이스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());

		Member[] member = new Member[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			member[i] = new Member(age, name);
		}

		Arrays.sort(member, new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				// TODO Auto-generated method stub
				return o1.age - o2.age;
			}
		});
		
		for(int i = 0; i < n; i++) {
			sb.append(member[i]);
		}

		System.out.println(sb);
	}

	static class Member {
		int age;
		String name;

		public Member(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
		
	}
}