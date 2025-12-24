import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        int curX = 0;
        int curY = 0;
        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int d = getIntDir(direction);
            int distance = sc.nextInt();

            curX += dx[d] * distance;
            curY += dy[d] * distance;

        }

        System.out.println(curX + " " + curY);
    }

    static int getIntDir(char direction){
        if(direction == 'W'){
            return 0;
        }else if(direction == 'S'){
            return 1;
        }else if(direction == 'N'){
            return 2;
        }else{
            return 3;
        }
    }
}