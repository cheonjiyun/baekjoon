import java.util.*;
import java.io.*;


public class Main {

    static int N;
    static int T;

    static boolean[][][] believe;
    static int[][] value;

    static Queue<Representive> representives = new PriorityQueue();;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        believe = new boolean[N][N][3];
        value = new int[N][N];

        for(int i = 0; i < N; i++){
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                if(line[j] == 'T'){
                    believe[i][j][0] = true;
                }else if(line[j] == 'C'){
                    believe[i][j][1] = true;
                }else if(line[j] == 'M'){
                    believe[i][j][2] = true;
                }
            }
        }

        for(int i = 0; i < N; i++){
             st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                value[i][j] = Integer.parseInt(st.nextToken());       
            }
        }

        morning();
        lunch();
        dinner();
        print(sb);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(value[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(printFood(believe[i][j]) + " ");
            }
            System.out.println();
        }

        System.out.println(sb);
    }

    public static void print(StringBuilder sb){
        int[] result = new int[7];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int calResult = calc(believe[i][j]);
                if(calResult == 7){
                    result[0] += value[i][j];
                }else if(calResult == 6){
                    result[1] += value[i][j];
                }else if(calResult == 5){
                    result[2] += value[i][j];
                }else if(calResult == 3){
                    result[3] += value[i][j];
                }else if(calResult == 1){
                    result[4] += value[i][j];
                }else if(calResult == 2){
                    result[5] += value[i][j];
                }else if(calResult == 4){
                    result[6] += value[i][j];
                }
            }
        }

        for(int i = 0; i < 7; i++){
            sb.append(result[i]);

            if(i != 6){
                sb.append(" ");
            }
        }
        sb.append("\n");
    }

    public static int calc(boolean[] foods){
        int out = 0;
        if(foods[0]){
            out += 4;
        }if(foods[1]){
            out += 2;
        }if(foods[2]){
            out += 1;
        }
        return out;
    }

    public static String printFood(boolean[] foods){

        String out = "";
        if(foods[0]){
            out += "T";
        }if(foods[1]){
            out += "C";
        }if(foods[2]){
            out += "M";
        }
        return out;
    }

    public static void morning(){        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                value[i][j] += 1;
            }
        }
    }

    public static void lunch(){
        boolean[][] visited = new boolean[N][N];

        for(int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
                if(!visited[row][col]){
                    bfs(row, col, visited);
                    System.out.println();
                }
            }
        }
    }

    public static void dinner(){
        while(!representives.isEmpty()){
            Representive representative = representives.poll();
            spread(representative);
        }
    }
    
    public static void spread(Representive representative){
        int direction = representative.value % 4;
        int heart = representative.value - 1;
        value[representative.row][representative.col] = 1;

        Queue<RowCol> q = new ArrayDeque();
        q.offer(new RowCol(representative.row, representative.col));

        RowCol believer = new RowCol(representative.row, representative.col);

        // System.out.println("=== 전파자 " + believer + "==");

        while(!q.isEmpty() && heart > 0){
            RowCol cur = q.poll();

            int nextRow = cur.row + dr[direction];
            int nextCol = cur.col + dc[direction];
            RowCol target = new RowCol(nextRow, nextCol);
            if(isWall(nextRow, nextCol)) break; // 벽이면 그만     
            System.out.println(target);       

            q.offer(new RowCol(nextRow, nextCol));

            
            if(isSameFood(believe[nextRow][nextCol], believe[believer.row][believer.col])) continue; // 같은 음식이면 다음

            alreadySpread[nextRow][nextCol] = true;
            if(heart > value[nextRow][nextCol]){
                // 강한 전파
                System.out.println("강한 전파");
                forceSpread(believer, target);
                heart -= value[nextRow][nextCol] + 1;
                value[nextRow][nextCol] += 1;
            }else{
                // 약한 전파
                System.out.println("약한 전파");
                weakSpread(believer, target);

                value[nextRow][nextCol] += heart;
                heart = 0;
            }

        }
    }

    public static void forceSpread(RowCol believer, RowCol target){
        for(int i = 0; i < 3; i++){
            believe[target.row][target.col][i] = believe[believer.row][believer.col][i];
        }
    }

    public static void weakSpread(RowCol believer, RowCol target){
        for(int i = 0; i < 3; i++){
            if(believe[target.row][target.col][i] == false && believe[believer.row][believer.col][i] == true){
                believe[target.row][target.col][i] = true;
            }
        }
    }

    
    

    public static void bfs(int startRow, int startCol, boolean[][] visited){
        Queue<RowCol> q = new ArrayDeque();
        q.offer(new RowCol(startRow, startCol));
        visited[startRow][startCol] = true;

        Representive representative = new Representive(startRow, startCol, value[startRow][startCol]);
        int sum = 0;        

        while(!q.isEmpty()){
            RowCol cur = q.poll();
            // System.out.println(cur);

            // 대표자            
            if(value[cur.row][cur.col] > representative.value){
                representative = new Representive(cur.row, cur.col, value[cur.row][cur.col]);
            }else if(value[cur.row][cur.col] == representative.value && cur.row < representative.row){
                representative = new Representive(cur.row, cur.col, value[cur.row][cur.col]);
            }else if(value[cur.row][cur.col] == representative.value && cur.row < representative.row && cur.col < representative.col){
                representative = new Representive(cur.row, cur.col, value[cur.row][cur.col]);           
            }

            sum += 1; // 그룹 수
            value[cur.row][cur.col] -= 1; // 신앙심 깍기


            for(int i = 0; i < 4; i++){
                int nextRow = cur.row + dr[i];
                int nextCol = cur.col + dc[i];

                if(isWall(nextRow, nextCol)) continue;
                if(isSameFood(believe[nextRow][nextCol], believe[cur.row][cur.col])){
                    if(!visited[nextRow][nextCol]){
                        visited[nextRow][nextCol] = true;
                        q.offer(new RowCol(nextRow, nextCol));
                    }                 
                }
            }
        }

        value[representative.row][representative.col] += sum;
        representative.value = value[representative.row][representative.col];
        representives.offer(representative);
    }

    public static boolean isSameFood(boolean[] arr1, boolean[] arr2){
        for(int i = 0; i < 3; i++){
            if(arr1[i] == arr2[i]) continue;
            else return false;
        }
        return true;
    }

    public static boolean isWall(int row, int col){
        if(row < 0 || col < 0 || row >= N || col >= N) return true;
        else return false;
    }

    public static class RowCol{
        int row;
        int col;

        public RowCol(int row, int col){
            this.row = row;
            this.col = col;
        }

        public String toString(){
            return "[RowCol] " + row + " " + col;
        }
    }

    public static class Representive extends RowCol implements Comparable<Representive>{
        int value;

        public Representive(int row, int col, int value){
            super(row, col);
            this.value = value;
        }

        public int compareTo(Representive o1){
            if(o1.value == this.value && o1.row == this.row){
                return this.col - o1.col;
            }else if(o1.value == this.value && o1.row != this.row){                
                return this.row - o1.row;
            }else{
                return o1.value - this.value;
            }
            
        }

        
        public String toString(){
            return "[Representive] " + row + " " + col + " " + value;
        }
    }
}