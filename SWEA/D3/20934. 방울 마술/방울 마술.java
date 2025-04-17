import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		sc.nextLine();  // 남아있는 개행 문자를 처리하기 위해 nextLine()을 추가
		
		for(int tc=1;tc<=T;tc++) {
			//입력 조건: 문자열+공백+정수가 한줄로 들어옴
			 // 한 줄을 받아서 공백 기준으로 나눔
	        String input = sc.nextLine();
	        String[] parts = input.split(" ");
	        
	        String str = parts[0];
			int K=Integer.parseInt(parts[1]);
			
			int ball=-1;
			for(int i=0;i<3;i++) {
				if(str.charAt(i)=='o') {
					ball=i;
				}
			}
			
			for(int i=0;i<K;i++) {
				if(ball==1 || ball==2) {//가운데에 있으면
					ball--;//왼쪽이동
				}else{
					ball++;
				}
			}
			
			System.out.println("#"+tc+" "+ball);
			
		}
	}
}