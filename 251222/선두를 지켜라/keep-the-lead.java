import java.util.Scanner;

public class Main {

    static int MAX = 1000 * 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] locationA = new int[MAX];
        int[] locationB = new int[MAX];

        int time = 0;
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int t = sc.nextInt();

            for(int j = 0; j < t; j++){
                time++;
                locationA[time] = locationA[time-1] + u;
            }
        }

        time = 0;
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int t = sc.nextInt();

            for(int j = 0; j < t; j++){
                time++;
                locationB[time] = locationB[time-1] + u;
            }
        }

        int result = 0;
        int last = 0;
        for(int i = 1; i <= time; i++){
            int cur = biggerAB(locationA[i], locationB[i]);

            if((last == 1 && cur == 2) || (last == 2 && cur == 1)){
                result++;
            }

            if(cur != 3){
                last = cur;
            }
        }

        System.out.println(result);
    }

    // A; 1  B: 2
    static int biggerAB(int a, int b){
        if(a > b){
            return 1;
        }else if(a < b){
            return 2;
        }else{
            return 3;
        }
    }
}