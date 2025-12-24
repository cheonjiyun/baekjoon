import java.util.Scanner;
public class Main {

    static int n;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){ 

                int count1 = 0;
                for(int d = 0; d < 4; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if(inRange(nx, ny) && arr[nx][ny] == 1){
                        count1++;
                    }
                }

                if(count1 >= 3){
                    count++;
                }
            }
        }

        System.out.println(count);
    }


    static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}