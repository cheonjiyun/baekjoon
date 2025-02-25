import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// 오름차순
				if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}else {
					return Math.abs(o1) - Math.abs(o2);					
				}
			}
		});

		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(in.readLine());
			if (input != 0) {
				// 추가
				queue.offer(input);

			} else {
				// 제거
				if(queue.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(queue.poll());					
				}
			}
		}
		System.out.println(sb);
	}
}