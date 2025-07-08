import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();

            int left = 0;
            int right = n - 1;
            boolean can = false;
            int mid = (right + left) / 2;
            while(left <= right){
                mid = (right + left) / 2;
                
                if(arr[mid] < x){
                    left = mid + 1;
                }else if(arr[mid] > x){
                    right = mid - 1;
                }else{

                    can = true;
                    break;
                }
            }
            if(can){
                System.out.println(mid + 1);
            }else{
                System.out.println(-1);
            }
            // Please write your code here.
        }
    }
}