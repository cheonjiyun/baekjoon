import java.util.Scanner;
public class Main {

    static int minNumber = 0 + 1000 * 100;
    static int maxNumber = 0 + 1000 * 100;
    static int curNumber = 0 + 1000 * 100;

    static int[] arrCountWhite = new int[1000 * 100 * 2 + 1];
    static int[] arrCountBlack = new int[1000 * 100 * 2 + 1];
    static int[] arrColor = new int[1000 * 100 * 2 + 1]; // 0: 일반, 1: 검정, -1: 하양, 2: 회색

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            // 현재 칠하고 이동
            paint(d);

            for(int j = 0; j < x-1; j++){
                if(d == 'L'){
                    curNumber--; // 이동
                    minNumber = Math.min(minNumber, curNumber);
                    paint(d);

                }else if(d == 'R'){
                    curNumber++;
                    maxNumber = Math.max(maxNumber, curNumber);
                    paint(d);
                }
            }
        }

        int white = 0;
        int black = 0;
        int gray = 0;

        for(int i = minNumber; i <= maxNumber; i++){
            if(arrColor[i] == -1){
                white++;
            }else if(arrColor[i] == 1){
                black++;
            }else if(arrColor[i] == 2){
                gray++;
            }
        }

        System.out.println(white + " " + black + " " + gray);
        // Please write your code here.
    }

    public static void paint(char d){
        // 현재 칠하기
        if(d == 'L'){
            arrColor[curNumber] = -1;
            arrCountWhite[curNumber] += 1;
        }else if(d == 'R'){
            arrColor[curNumber] = 1;
            arrCountBlack[curNumber] += 1;
        }

        // 4번 이상은 회색
        if(arrCountWhite[curNumber] >= 2 && arrCountBlack[curNumber] >= 2){
            arrColor[curNumber] = 2;
        }
    }
}