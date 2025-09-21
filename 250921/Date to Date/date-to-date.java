import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.
        int[] numOfDays = {31,28,31,30,31,30,31,31,30,31,30,31};

        int fullMonth = 0;
        for(int i = m1 ; i <= m2; i++){
            fullMonth += numOfDays[i - 1];
        }
        int start = d1 - 1;
        int end = numOfDays[m2 - 1] - d2;


        System.out.println(fullMonth - start - end);
    }
}