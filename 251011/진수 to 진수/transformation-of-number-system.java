import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        String N = sc.next();
        // Please write your code here.

        int decimal = 0;
        // 1. a진수로 된 n을 10진수로 변환
        for(int i = 0; i < N.length(); i++){
            decimal = decimal * A + Character.getNumericValue(N.charAt(i));
        }

        // 2.  b진수로 변환
        String result = "";
        while(true){
            if(decimal < B){
                result = decimal + result;
                break;
            }

            result = decimal % B + result;
            decimal = decimal / B;
        }
        
        System.out.println(result);
    }
}