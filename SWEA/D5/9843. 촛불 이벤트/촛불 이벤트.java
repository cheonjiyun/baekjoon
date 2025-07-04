import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            long n = sc.nextLong();

            long left = 1;
            long right = (long)Math.sqrt(2 * n); 
            long k = -1;

            boolean isCan = false;
            while(left <= right){
                long mid = (left + right) / 2;
                long sum = (mid * (mid + 1)) / 2;

                if(sum == n){
                    isCan = true;
                    k = mid;
                    break;
                } else if(sum < n){
                    left = mid + 1;
                } else{
                    right = mid - 1;   
                }
            }

            if(!isCan) {
                k = -1;
            }

            System.out.printf("#%d %d\n", test_case, k);
        }
    }
}