import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int p = sc.nextInt();
            
            boolean[] arr = new boolean[1_000_001 + p];
            for(int i = 0; i < n; i++){
              arr[sc.nextInt()] = true;
            }
            
            int left = 0;
            
            int currentP = 0;
            
            int result = 0;
                        
            for(int right = 0; right < arr.length; right++){
            	if(!arr[right]){
                	currentP++;
                }
                
                while(currentP > p){
                	if(!arr[left]){
                    	currentP--;
                    }
                    left++;
                }
                
                result = Math.max(result, right - left + 1);
            }
            
            System.out.printf("#%d %d\n", test_case, result);
		}
	}
}