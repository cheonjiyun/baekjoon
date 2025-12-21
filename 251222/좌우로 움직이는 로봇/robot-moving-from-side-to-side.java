import java.util.*;

public class Main {

    static int MAX = 1_000_001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] location = new int[2][MAX];
        
        int maxTime =0;
        int timeA = 0;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            // Please write your code here.

            while(t-- > 0){
                timeA++;
                maxTime = Math.max(maxTime, timeA);
                if(d == 'L'){
                    location[0][timeA] = location[0][timeA - 1] - 1;
                }else{
                    location[0][timeA] = location[0][timeA - 1] + 1;
                }
            }
        }
        
        int timeB = 0;
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            
            while(t-- > 0){
                timeB++;
                maxTime = Math.max(maxTime, timeB);
                
                if(d == 'L'){
                    location[1][timeB] = location[1][timeB - 1] - 1;
                }else{
                    location[1][timeB] = location[1][timeB - 1] + 1;
                }
            }
        }

        for(int i = timeA + 1; i <= maxTime; i++){
            location[0][i] = location[0][i-1];
        }
        for(int i = timeB; i <= maxTime; i++){
            location[1][i] = location[1][i-1];
        }
        
        boolean together = true;
        int count = 0;
        for(int i = 1; i <= maxTime; i++){
            
            if(!together && location[0][i] == location[1][i]){
          
                count++;
            }
            if(location[0][i] == location[1][i]){
                together = true;
            }else{
                together = false;
            }
        }
        
        System.out.println(count);
    }
}