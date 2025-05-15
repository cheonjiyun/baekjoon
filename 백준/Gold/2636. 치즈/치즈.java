import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int r;
	private static int c;
	private static int[][] arr;
	private static int remainCheeseCount;
	private static int beforeChecese;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("src/swea_문제이름/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new int[r][c];
		remainCheeseCount = 0;

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(arr[i][j] == 1) {
					remainCheeseCount++;
				}
			}
		}
		

		beforeChecese = remainCheeseCount;

		int count = 0;
		while(remainCheeseCount > 0) {
			
			beforeChecese = remainCheeseCount;	
			count++;
			bfs(0, 0);
			

			
			
		}
		
		sb.append(count).append("\n");
		sb.append(beforeChecese);
	
		
		
		System.out.println(sb);
	}

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc= {0, 1, 0, -1};
	
	static void bfs(int startRow, int startCol) {
		int meltCount = 0;
		
		Queue<RowCol> q = new ArrayDeque<RowCol>();
		q.offer(new RowCol(startRow, startCol));
		
		boolean[][] visited = new boolean[r][c];
		visited[startRow][startCol] = true;
		
		while(!q.isEmpty()) {
			RowCol cur = q.poll();
			
			for(int d= 0 ; d< 4; d++) {
				int nextRow = cur.row + dr[d];
				int nextCol = cur.col + dc[d];
				
				if(nextRow < 0 || nextCol < 0 || nextRow >= r || nextCol >= c || visited[nextRow][nextCol]) {
					continue;
				}
				
				visited[nextRow][nextCol]= true;
				
				if(arr[nextRow][nextCol] == 1) {
					arr[nextRow][nextCol] = 0;	
					meltCount++;
				}else {
					q.offer(new RowCol(nextRow, nextCol));					
				}
				
			}
		}
		
		remainCheeseCount -= meltCount;		
	}
	

	static class RowCol {
		int row;
		int col;

		public RowCol(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "RowCol [row=" + row + ", col=" + col + "]";
		}
	}
}