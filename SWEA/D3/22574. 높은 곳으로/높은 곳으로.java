import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int N=sc.nextInt();
			int P=sc.nextInt();
			
			int floor=0;

			
			for(int i=1;i<=N;i++) {		
				
				floor+=i;
					
				if(floor==P) {
					floor--;//도달하지 않도록 i-1만큼만 올라간다.
				}
			}
	        
			
			System.out.println(floor);
			
		}
	}
}