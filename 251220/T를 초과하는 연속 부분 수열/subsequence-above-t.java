import java.util.Scanner;

public class Main {

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];

        int count = 0;
        int result = 0;

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();

            if(arr[i] <= t){
                count = 0;
            }else if(i >= 1 && (arr[i-1] < arr[i])){
                count++;
            }else{
                count = 1;
            }

            // System.out.println(count);

            result = Math.max(result, count);
        }
        
        System.out.println(result);
        // Please write your code here.
    }
}