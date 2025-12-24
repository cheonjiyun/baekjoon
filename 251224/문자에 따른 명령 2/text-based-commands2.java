import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        char[] commands = s.toCharArray();
        int curX = 0;
        int curY = 0;
        int d = 0;
        for(char c : commands){
            if(c == 'L'){
                d = (d -1 + 4) % 4;

            }else if(c == 'R'){
                d = (d +1 + 4) % 4;

            }
            
            else{
                curX += dx[d];
                curY += dy[d];
            }

        }
        System.out.println(curX + " " + curY);
        // Please write your code here.
    }
}