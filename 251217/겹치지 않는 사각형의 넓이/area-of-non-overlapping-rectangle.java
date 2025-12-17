import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ax1 = sc.nextInt() + 1000;
        int ay1 = sc.nextInt() + 1000;
        int ax2 = sc.nextInt() + 1000;
        int ay2 = sc.nextInt() + 1000;
        int bx1 = sc.nextInt() + 1000;
        int by1 = sc.nextInt() + 1000;
        int bx2 = sc.nextInt() + 1000;
        int by2 = sc.nextInt() + 1000;
        int mx1 = sc.nextInt() + 1000;
        int my1 = sc.nextInt() + 1000;
        int mx2 = sc.nextInt() + 1000;
        int my2 = sc.nextInt() + 1000;

        boolean[][] arr = new boolean[2001][2001];

        for(int i = ax1; i < ax2; i++){
            for(int j = ay1; j < ay2; j++){
                arr[i][j] = true;
            }
        }

        for(int i = bx1; i < bx2; i++){
            for(int j = by1; j < by2; j++){
                arr[i][j] = true;
            }
        }

        for(int i = mx1; i < mx2; i++){
            for(int j = my1; j < my2; j++){
                arr[i][j] = false;
            }
        }

        int count = 0;

        for(int i = 0; i < 2001; i++){
            for(int j = 0; j < 2001; j++){
                if(arr[i][j]){
                    count++;
                }
            }
        }

        System.out.println(count);
        // Please write your code here.
    }
}