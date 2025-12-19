import java.util.Scanner;

public class Main {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];

        int count = 0;
        int result = 0;

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            count++;
            result = Math.max(result, count);
            if(i != 0 && !isSame(i)){
                count=0;
            }
        }

        System.out.println(result);
        // Please write your code here.
    }

    static boolean isSame(int i){
        return (arr[i-1] < 0 && arr[i] < 0) || (arr[i-1] > 0 && arr[i] > 0);
    }
}