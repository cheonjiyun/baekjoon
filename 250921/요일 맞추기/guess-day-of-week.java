import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.

        int[] numOfDays = {0,31,28,31,30,31,30,31,31,30,31,30,31};

        int days = 0;
        for(int i = m1; i <= m2; i++){
            days += numOfDays[i];
        }
        
        days -= d1 - 1;
        days -= numOfDays[m2] - d2 + 1;
        
        while(days < 0){
            days += 7;
        }

        String[] strOfDay = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        
        System.out.println(strOfDay[days % 7]);
    }
}