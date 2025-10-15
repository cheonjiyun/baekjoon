import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];

        int[] arr = new int[101];
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();

            for(int j = start[i]; j <= end[i]; j++){
                arr[j] += 1;
            }
        }

        int result = 0;
        for(int i = 0; i < 101; i++){
            result = Math.max(result, arr[i]);
        }

        System.out.println(result);
        // Please write your code here.
    }
}