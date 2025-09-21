import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        // Please write your code here.
        strOfDay.put("Mon", 0);
        strOfDay.put("Tue", 1);
        strOfDay.put("Wed", 2);
        strOfDay.put("Thu", 3);
        strOfDay.put("Fri", 4);
        strOfDay.put("Sat", 5);
        strOfDay.put("Sun", 6);

        int diff = getDays(m2,d2) - getDays(m1,d1) + 1;
        int result = diff / 7;

        if(strOfDay.get(A) <= diff % 7){
            result++;
        }
        
        System.out.println(result);
    }

    static int[] numOfDays = {0,31,29,31,30,31,30,31,31,30,31,30,31};
    static HashMap<String, Integer> strOfDay = new HashMap<>();
    
    
    public static int getDays(int m, int d){
        int day = 0;
        for(int i = 1; i < m; i++){
            day += numOfDays[i];
        }
        day += d;
        return day;        
    }
}