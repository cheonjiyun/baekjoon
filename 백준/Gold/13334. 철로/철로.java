import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		List<Node> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int h = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());

			if(h < o) {
				list.add(new Node(h, o));
			}else {
				list.add(new Node(o, h));
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		
		Queue<Node> pq = new PriorityQueue<Main.Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {				
				return o1.house - o2.house;
			}
		});
		
		list.sort(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.office - o2.office;
			}
		});

		Node currentNode = list.get(0);
		int currentCount = 0;
		int currentMax = 0;
		for(int i = 0; i < n; i++) {
			currentNode = list.get(i);			

			pq.offer(currentNode); // 현재 범위에 포함되어있는 Node들을 PQ에 넣는다.
			currentCount++; // 하나 추가
			
			int front = currentNode.office - d; // 현재 범위
			
			while(!pq.isEmpty() && pq.peek().house < front) {
				// 범위를 벗어나는 Node들은 삭제
				pq.poll();
				currentCount--;
			}
			
			currentMax = Math.max(currentMax, currentCount);
			
		}
		System.out.println(currentMax);
		
	}

	static class Node {
		int house;
		int office;

		public Node(int house, int office) {
			super();
			this.house = house;
			this.office = office;
		}

		@Override
		public String toString() {
			return "Node [house=" + house + ", office=" + office + "]";
		}

	}
}