import java.util.Scanner;
public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int time = 0;

        int curR = 0;
        int curC = 0;

        for(int i = 0; i < n; i++){
            char dir = sc.next().charAt(0);
            int d = getDir(dir);
            int dist = sc.nextInt();

            for(int t = 0; t < dist; t++){
                time++;

                curR += dr[d];
                curC += dc[d];

                if(curR == 0 && curC == 0){
                    System.out.println(time);
                    return;
                }
            }
        }
        System.out.println(-1);
        // Please write your code here.
    }

    static int getDir(char d){
        if(d == 'N'){
            return 0;
        }else if(d == 'E'){
            return 1;
        }else if(d == 'S'){
            return 2;
        }else{
            return 3;
        }
    }
}