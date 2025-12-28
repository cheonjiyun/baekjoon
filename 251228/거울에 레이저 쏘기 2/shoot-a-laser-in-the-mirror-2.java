import java.util.Scanner;

public class Main {

    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,-1,0,1};

    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int startNum = sc.nextInt();
        
        int dir = (startNum -1) / n;

        int startRow = 0;
        int startCol = 0;
        int d = 3;
        for(int i = 0; i < startNum-1; i++){
            int nrow = startRow + dr[d];
            int ncol = startCol + dc[d];

            // 벗어날시 방향전환만
            if(!isRange(nrow,ncol)){
                d = (d + 4 + 1) % 4;
                continue; 
            }
            startRow = nrow;
            startCol = ncol;
        }
      //  System.out.println(startRow + " " + startCol);
        
        int result = 0;
        while(isRange(startRow, startCol)){
            result++;

           // System.out.println(startRow + " " + startCol + " " + dir);

            dir = nextDir(grid[startRow][startCol], dir);
            int nrow = startRow + dr[dir];
            int ncol = startCol + dc[dir];
            startRow = nrow;
            startCol = ncol;
            //  System.out.println(startRow + " " + startCol + " " + dir);
  //System.out.println();

        }

        System.out.println(result);
        
        // Please write your code here.
    }

    static boolean isRange(int r, int c){
        return r >= 0 && c >= 0 && r < n && c < n;
    }

    static int nextDir(char wall, int dir){
        if(wall == '/'){
            if(dir == 0){
                return 1;
            }else if(dir == 1){
                return 2;
            }else if(dir == 2){
                return 3;
            }else{
                return 0;
            }
        }else{
            if(dir == 0){
                return 3;
            }else if(dir == 1){
                return 2;
            }else if(dir == 2){
                return 1;
            }else{
                return 0;
            }
        }

    }
}