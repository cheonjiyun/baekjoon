import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commands = sc.next();

        int curDir = 0;

        int curR = 0;
        int curC = 0;

        int time = 0;

        for(char c : commands.toCharArray()){
            time++;

            if(c == 'L'){
                curDir = (curDir + 4 - 1) % 4;
            }else if(c == 'R'){
                curDir = (curDir + 4 + 1) % 4;
            }else{
                curR = curR + dr[curDir];
                curC = curC + dc[curDir];
            }

            if(curR == 0 && curC == 0){
                System.out.println(time);
                return;
            }
        }
        System.out.println(-1);
        // Please write your code here.
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

}