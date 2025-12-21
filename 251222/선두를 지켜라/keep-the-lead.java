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

        boolean isFrontA = locationA[1] > locationB[1];
        int result = locationA[1] == locationB[1] ? 0 : 1;
        for(int i = 0; i < time; i++){
            if(locationA[i] > locationB[i] && !isFrontA){
                result++;
            }else if(locationA[i] < locationB[i] && isFrontA){
                result++;
            }
        }

        System.out.println(result);
        // Please write your code here.
    }
}