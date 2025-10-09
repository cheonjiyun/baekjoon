import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        String result = "";
        while(n > 0){
            result = (n % 2) + result;
            n = n/2;
        }
        System.out.println(result);
    }
}