import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
       
        int start = getMinute(11,11,11);
        int end = getMinute(A,B,C);

        if(end < start){
            System.out.println(-1);
        }else{
            System.out.println(end - start);
        }
    }

    public static int getMinute(int day, int clock, int minute){
        return (day * 60 * 24) + (clock * 60) + minute;
    }
}