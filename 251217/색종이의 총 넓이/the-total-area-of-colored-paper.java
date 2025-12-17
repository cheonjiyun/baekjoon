import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        boolean[][] arr = new boolean[101][101];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();

            for(int col = x[i]; col < x[i] + 8; col++){
                for(int row = y[i]; row < y[i] + 8; row++){
                    arr[row][col] = true;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                if(arr[i][j])
                    count++;
            }
        }

        System.out.println(count);
        // Please write your code here.
    }
}