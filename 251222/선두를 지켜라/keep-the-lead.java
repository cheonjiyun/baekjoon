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
        for(int i = 1; i <= time; i++){
            boolean last = locationA[i-1] > locationB[i-1];
            boolean cur = locationA[i] > locationB[i];

            if(last != cur){
                result++;
            }
        }

        System.out.println(result);
    }
}