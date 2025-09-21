import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.
        int days = getTime(m2,d2) - getTime(m1,d1);
        
        while(days < 0){
            days += 7;
        }

      
        System.out.println(strOfDay[days % 7]);
    }

    static int[] numOfDays = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    static String[] strOfDay = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        
    public static int getTime(int m, int d){
        int days = 0;
        for(int i = 1; i < m; i++){
            days += numOfDays[i];
        }
        days += d;

        return days;
    }
}