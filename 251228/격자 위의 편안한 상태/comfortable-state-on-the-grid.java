import java.util.Scanner;
public class Main {

    static int n;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.

        int[][] arr = new int[n+1][n+1];

        for(int i = 0; i < m; i++){
            int r = sc.nextInt();
            int c = sc.nextInt();

            int count = 0;
            for(int d= 0; d < 4; d++){
                int nrow = r + dr[d];
                int ncol = c + dc[d];

                if(!isRange(nrow,ncol)){
                    continue;
                }
                if(arr[nrow][ncol] == 1){
                    count++;
                }
            }
            
            arr[r][c] = 1;
            if(count == 3){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

    static boolean isRange(int r, int c){
        return r >= 1 && c >= 1 && r <= n && c <= n;
    }
}