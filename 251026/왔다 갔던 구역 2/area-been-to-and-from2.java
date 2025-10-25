import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int maxvalue = 100 * 10 * 2 + 1;
        int[] arr = new int[maxvalue];

        int[] x1 = new int[N];
        int[] x2 = new int[N];

        int current = 1000;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            
            if(dir == 'L'){
                x1[i] = current - x;
                x2[i] = current;
                current -= x;
            }else if(dir == 'R'){
                x1[i] = current;
                x2[i] = current + x;
                current += x;
            }
            // Please write your code here.
        }

        for(int i = 0; i < N ;i++){
            //System.out.println((x1[i] - 1000) + " " + (x2[i] - 1000));
            for(int j = x1[i]; j < x2[i]; j++){
                arr[j] += 1;
                
            }
            
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