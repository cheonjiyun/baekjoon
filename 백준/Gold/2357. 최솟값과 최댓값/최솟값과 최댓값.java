import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] segtreeMax;
	static int[] segtreeMin;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		int leaf = 1;
		while(leaf < n) {
			leaf *= 2;
		}
		
		segtreeMax = new int[leaf * 2 + 1];
		segtreeMin = new int[leaf * 2 + 1];
		for(int i = leaf; i < leaf * 2 + 1; i++) {
			segtreeMin[i] = Integer.MAX_VALUE;
		}
		

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			segtreeMax[leaf + i] = number;
			segtreeMin[leaf + i] = number;
		}
		
		for(int i = leaf - 1; i >= 1; i--) {
			segtreeMax[i] = Math.max(segtreeMax[i * 2], segtreeMax[i * 2 + 1]);
			segtreeMin[i] = Math.min(segtreeMin[i * 2], segtreeMin[i * 2 + 1]);
		}

//		System.out.println(Arrays.toString(segtreeMax));
		
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			int max = getMax(a,b,0,leaf-1,1);
			int min = getMin(a,b,0,leaf-1,1);
			
			sb.append(min).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int getMax(int wantStart, int wantEnd, int start, int end, int idx) {
		if(wantEnd < start || end < wantStart) {
			return Integer.MIN_VALUE;
		}
		if(wantStart <= start && end <= wantEnd) {
			return segtreeMax[idx];
		}

		int mid = (start + end) / 2;
		int left = getMax(wantStart, wantEnd, start, mid, idx * 2);;
		int right = getMax(wantStart, wantEnd, mid + 1, end, idx * 2 + 1);
		
		return Math.max(left, right);		
	}
	
	public static int getMin(int wantStart, int wantEnd, int start, int end, int idx) {
		if(wantEnd < start || end < wantStart) {
			return Integer.MAX_VALUE;
		}
		if(wantStart <= start && end <= wantEnd) {
			return segtreeMin[idx];
		}

		int mid = (start + end) / 2;
		int left = getMin(wantStart, wantEnd, start, mid, idx * 2);;
		int right = getMin(wantStart, wantEnd, mid + 1, end, idx * 2 + 1);
		
		return Math.min(left, right);		
	}
}