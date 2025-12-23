import java.util.Scanner;
public class Main {

    static int max = 1_000 * 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int time = 0;
        int[][] locations = new int[2][max];
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int t = sc.nextInt();

            while(t-- > 0){
                time++;
                locations[0][time] = locations[0][time-1] + u;
            }
        }

        time = 0;
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int t = sc.nextInt();

            while(t-- > 0){
                time++;
                locations[1][time] = locations[1][time-1] + u;
            }
        }

        int top = 0;
        int result = 0;
        for(int i = 1; i <= time; i++){
            int curTop = whatTop(locations[0][i], locations[1][i]);

            if(top != curTop){
                top = curTop;
                result++;
            }
        }

        System.out.println(result);
        // Please write your code here.
    }

    public static int whatTop(int a, int b){
        if(a > b){
            return 1;
        }else if(a < b){
            return 2;
        }else{
            return 3;
        }
    }  

}