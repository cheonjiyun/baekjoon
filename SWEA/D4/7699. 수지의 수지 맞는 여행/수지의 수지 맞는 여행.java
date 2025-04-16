import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			R=sc.nextInt();
			C=sc.nextInt();
			
			island=new char[R][C];
			//Set<Character> set=new HashSet<>();
			
			for(int i=0;i<R;i++) {
				String s=sc.next();
				int j=0;
				for(char c:s.toCharArray()) {
					island[i][j]=c;
					j++;
					//set.add(c);
				}
			}
			
			seen= new boolean[26];
			max= 0;
			
			//같은 알파벳 명물을 두 번 이상 보지 않도록
			seen[island[0][0]-'A']=true;
			dfs(0,0,1);
			
			System.out.println("#"+tc+" "+max);
			
		}
		
		
	}
	
	static int R, C, max;
	static boolean[] seen;
	static char[][] island;
	static int[][] dir= {{1,0},{0,1},{-1,0},{0,-1}};
	
	
	static void dfs(int x, int y, int cnt) {
		if(max<cnt) {
			max=cnt;
		}
		
		for(int i=0;i<4;i++) {
			int nx=dir[i][0]+x;
			int ny=dir[i][1]+y;
			
			if(nx>=0 && nx<R && ny>=0 && ny<C) {
				char c=island[nx][ny];
				if(!seen[c-'A']) {
					seen[c-'A']=true;
					dfs(nx,ny,cnt+1);
					seen[c-'A']=false;
				}
			}
		}
		
		
	}
	
	
}
