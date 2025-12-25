import java.util.Scanner;
public class Main {

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int[][] arr;

    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];

        int dir = 0;
        int r = 0;
        int c = 0;

        for(int i = 1; i <= n * m; i++){
            arr[r][c] = i;

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(!isCanGo(nr, nc)){
                dir = (dir + 1) % 4;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }

            r = nr;
            c = nc;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        // Please write your code here.
    }


    static boolean isCanGo(int r, int c){
        return r >= 0 && c >= 0 && r < n && c < m && arr[r][c] == 0;
    }
}