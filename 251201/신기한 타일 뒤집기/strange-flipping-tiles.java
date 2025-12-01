import java.util.Scanner;
public class Main {

    static int ARR_MAX_VALUE = 1000 * 100 * 2 + 1;

    static int[] tiles = new int[ARR_MAX_VALUE]; // 0: 기존, 1: 블랙, -1: 화이트
    static int currentNumber = 1000 * 100;

    static int minNumber = 1000 * 100;
    static int maxNumber = 1000 * 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            turn(d);
            for(int j = 0; j < x-1; j++){
                if(d == 'L'){
                    currentNumber--;
                    minNumber = Math.min(minNumber, currentNumber);
                    turn(d);
                }else if(d == 'R'){
                    currentNumber++;
                    maxNumber = Math.max(maxNumber, currentNumber);
                    turn(d);
                }
            }
        }

        int white = 0;
        int black = 0;
        for(int i = minNumber; i <= maxNumber; i++){
            if(tiles[i] == -1){
                white++;
            }else if(tiles[i] == 1){
                black++;
            }
        }
        System.out.println(white + " " + black);
    }

    public static void turn(char d){
        if(d == 'L'){
            tiles[currentNumber] = -1;
        }else if(d == 'R'){
            tiles[currentNumber] = 1;
        }
    }
}