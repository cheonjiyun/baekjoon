import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arrN = new int[1000 * 1000 + 1];
        int[] arrM = new int[1000 * 1000 + 1];

        int time = 0;
        int currentLoc = 0;
        int maxTime = 0;

        for(int i = 0; i < n; i++){
            char d = sc.next().charAt(0);
            int t = sc.nextInt();


            for(int j = 0; j < t; j++){
                time++;
                maxTime = Math.max(maxTime, time);
                if(d == 'L'){
                    currentLoc--;
                }else if(d == 'R'){
                    currentLoc++;
                }
                arrN[time] = currentLoc; 
            }
        }
        for(int i = time +1; i <= 1000 * 1000;i++){
            arrN[i] = currentLoc;
        }

        time = 0;
        currentLoc = 0;
        for(int i = 0; i < m; i++){
            char d = sc.next().charAt(0);
            int t = sc.nextInt();

            for(int j = 0; j < t; j++){
                time++;
                maxTime = Math.max(maxTime, time);
                if(d == 'L'){
                    currentLoc--;
                }else if(d == 'R'){
                    currentLoc++;
                }
                arrM[time] = currentLoc; 
            }
        }
        for(int i = time +1; i <= 1000 * 1000;i++){
            arrM[i] = currentLoc;
        }

        for(int i = 1; i <= maxTime; i++){
           // System.out.println(arrN[i] + " " + arrM[i]);
            if(arrN[i] == arrM[i]){
                System.out.println(i);
                return;
            }
        }
        
        System.out.println(-1);
        // Please write your code here.
    }
}