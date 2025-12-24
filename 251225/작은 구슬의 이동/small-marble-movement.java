import java.util.Scanner;

public class Main {

    static int[] dr = {0, -1, 1, 0};
    static int[] dc = {-1, 0, 0, 1};

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();
        String D = sc.next();

        int dir = getDir(D);

        for(int time = 0; time < T; time++){
            int nrow = R + dr[dir];
            int ncol = C + dc[dir];

            if(isRange(nrow, ncol)){
                R = nrow;
                C = ncol;
            }else{
                dir = 3 - dir;
            }

        }

        System.out.println(R + " " + C);
        // Please write your code here.
    }

    static boolean isRange(int r, int c){
        return r >= 1 && c >= 1 && r <= N && c <= N;
    }

    static int getDir(String d){
        if(d.equals("L")){
            return 0;
        }else if(d.equals("U")){
            return 1;
        }else if(d.equals("D")){
            return 2;
        }else{
            return 3;
        }
    }
}