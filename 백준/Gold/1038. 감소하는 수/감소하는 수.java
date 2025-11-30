import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Long> list = new ArrayList<Long>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int input = Integer.parseInt(st.nextToken());
		
		if(input >= 1023) {
			System.out.println(-1);
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			make(i, 1);
		}
		
		list.sort(new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				return (int) (o1 - o2);
			}

		});
		
		System.out.println(list.get(input));
	}
	
	public static void make(long number, int k) {
		if(k > 10) return;

		list.add(number);
		
		for(int i = 0; i < number % 10; i++) {
			long makedNumber = (number * 10) + i;
			make(makedNumber, k+1);
		}
	}
}