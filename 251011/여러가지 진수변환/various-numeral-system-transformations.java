import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.
        String result = "";
        while(true){
            if(n < b){
                result = n + result;
                break;
            }

            result = (n % b) + result;
            n = n / b;
        }
        System.out.println(result);
    }
}