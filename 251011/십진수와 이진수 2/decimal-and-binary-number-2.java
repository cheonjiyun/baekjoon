import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        
        // 1. 십진수로 바꾸기
        int result = 0;
        for(int i = 0; i < binary.length(); i++){
            result = result * 2 + Character.getNumericValue(binary.charAt(i));
        }

        // 2. 17곱하기
        result = result * 17;

        String answer = "";
        // 3. 2진수로 바꾸기
        while(true){
            if(result < 2){
                answer = result + answer;
                break;
            }

            answer = result % 2 + answer;
            result = result / 2;
        }
        

        System.out.println(answer);
    }
}