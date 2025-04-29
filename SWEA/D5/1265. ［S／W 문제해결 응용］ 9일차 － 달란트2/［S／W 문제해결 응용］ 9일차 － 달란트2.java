
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int p = sc.nextInt();
            
            long result = 1;
            
            int q = n / p;
            int r = n % p;
           for(int i = 0; i < p - r; i++){
            	result *= q;
           }
            for(int i = 0 ; i < r; i++){
            	result *= q + 1;
            }
            System.out.printf("#%d %d\n", test_case, result);
		}
	}
}