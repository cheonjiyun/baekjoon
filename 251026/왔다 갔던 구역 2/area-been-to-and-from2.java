import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int maxvalue = 100 * 10 * 2 + 1;
        int[] arr = new int[maxvalue];

        int current = 1000;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);

            for(int j = 0; j < x; j++){
                
                arr[current] += 1;
                
                if(dir == 'L'){
                    current--;
                }else if(dir == 'R'){
                    current++;
                }
                
            }
            // Please write your code here.
        }

        int cnt = 0;
        for(int i = 0; i < maxvalue; i++){
            if(arr[i] >= 2){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}