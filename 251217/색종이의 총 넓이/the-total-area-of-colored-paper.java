import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        boolean[][] arr = new boolean[201][201];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt() + 100;
            y[i] = sc.nextInt() + 100;

            for(int col = x[i]; col < x[i] + 8; col++){
                for(int row = y[i]; row < y[i] + 8; row++){
                    arr[row][col] = true;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < 201; i++){
            for(int j = 0; j < 201; j++){
                if(arr[i][j])
                    count++;
            }
        }

        System.out.println(count);
        // Please write your code here.
    }
}