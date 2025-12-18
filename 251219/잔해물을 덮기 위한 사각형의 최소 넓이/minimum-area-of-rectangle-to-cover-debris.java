import java.util.Scanner;

public class Main {

    static int n = 2001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rect1_x1 = sc.nextInt() + 1000;
        int rect1_y1 = sc.nextInt() + 1000;
        int rect1_x2 = sc.nextInt() + 1000;
        int rect1_y2 = sc.nextInt() + 1000;
        int rect2_x1 = sc.nextInt() + 1000;
        int rect2_y1 = sc.nextInt() + 1000;
        int rect2_x2 = sc.nextInt() + 1000;
        int rect2_y2 = sc.nextInt() + 1000;
        // Please write your code here.

        boolean[][] arr = new boolean[n][n];

        for(int x = rect1_x1; x < rect1_x2; x++){
            for(int y = rect1_y1; y < rect1_y2; y++){
                arr[x][y] = true;
            }
        }

        for(int x = rect2_x1; x < rect2_x2; x++){
            for(int y = rect2_y1; y < rect2_y2; y++){
                arr[x][y] = false;
            }
        }

        int min_x = n;
        int max_x = 0;
        int min_y = n;
        int max_y = 0;

        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                if(arr[x][y]){
                    min_x = Math.min(min_x, x);
                    max_x = Math.max(max_x, x);
                    min_y = Math.min(min_y, y);
                    max_y = Math.max(max_y, y);
                }
            }
        }

        int result = (max_x - min_x + 1) * (max_y - min_y + 1);
        System.out.println(result);
    }
}