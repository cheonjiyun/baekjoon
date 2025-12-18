import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int RED = 1;
        int BLUE = 2;

        int[][] arr = new int[201][201];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt() + 100;
            int y1 = sc.nextInt() + 100;
            int x2 = sc.nextInt() + 100;
            int y2 = sc.nextInt() + 100;

            for(int x = x1; x < x2; x++){
                for(int y = y1; y < y2; y++){
                    if(i % 2 == 0){
                        arr[x][y] = RED;
                    }else{
                        arr[x][y] = BLUE;
                    }
                }
            }
        }

        int count = 0;
          for(int x = 0; x < 201; x++){
                for(int y = 0; y < 201; y++){
                    if(arr[x][y] == BLUE){
                        count++;
                    }
                }
            }

        System.out.println(count);

        // Please write your code here.
    }
}