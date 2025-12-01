import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];

        int[][] arr = new int[201][201];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt() + 100;
            y1[i] = sc.nextInt() + 100;
            x2[i] = sc.nextInt() + 100;
            y2[i] = sc.nextInt() + 100;

            for(int x = x1[i]; x < x2[i]; x++){
                for(int y = y1[i]; y < y2[i]; y++){
                    arr[x][y] = 1;
                }
            }
        }
        int count = 0;
        for(int x = 0; x < 201; x++){
            for(int y = 0; y < 201; y++){
                if(arr[x][y] == 1){
                    count++;
                }
            }
        }

        System.out.println(count);
        // Please write your code here.
    }
}