

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<ArrayList<Edge>> adjList = new ArrayList<ArrayList<Edge>>();

		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adjList.get(a).add(new Edge(b, c));
		}
		// 1번 도시에서
		Queue<Integer>[] kdist = new PriorityQueue[n + 1];
		for (int i = 0; i < n + 1; i++) {
			kdist[i] = new PriorityQueue<Integer>(Collections.reverseOrder());
		}

		kdist[1].add(0);
		Queue<PathState> q = new PriorityQueue<PathState>();
		q.offer(new PathState(1, 0));


		while (!q.isEmpty()) {
			PathState cur = q.poll();


			for (Edge node : adjList.get(cur.city)) {
				if(kdist[node.to].size() < k) {
					kdist[node.to].offer(cur.distance + node.time);
					q.offer(new PathState(node.to, cur.distance + node.time));
				}else if(kdist[node.to].peek() > cur.distance + node.time){
					kdist[node.to].poll();
					kdist[node.to].offer(cur.distance + node.time);
					q.offer(new PathState(node.to, cur.distance + node.time));
				}
				
			}
		}

		for (int i = 1; i <= n; i++) {
			if (kdist[i].size() < k) {
				System.out.println(-1);
			} else {
				System.out.println(kdist[i].peek());
			}
		}
	}

	static class PathState implements Comparable<PathState> {
		int city;
		int distance;

		public PathState(int i, int dist) {
			super();
			this.city = i;
			this.distance = dist;
		}

		@Override
		public int compareTo(PathState o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.distance, o.distance);
		}

		@Override
		public String toString() {
			return "Temp [i=" + city + ", dist=" + distance + "]";
		}

	}

	static class Edge {
		int to;
		int time;

		public Edge(int end, int time) {
			super();
			this.to = end;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Node [end=" + to + ", time=" + time + "]";
		}

		
	}
}
