import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int P = sc.nextInt();
        int T = sc.nextInt();

        int[] influ = new int[n+1];
        influ[P] = 1;

        int[] chance = new int[n+1];

        List<Node> infos = new ArrayList<Node>();
        for (int i = 0; i < T; i++) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            infos.add(new Node(t,x,y));
        }

        Collections.sort(infos);

        for(Node info : infos){
            boolean goY = false;
            if(influ[info.x] == 1 && chance[info.x] < k){
                goY = true;
            }
            boolean goX = false;
            if(influ[info.y] == 1 && chance[info.y] < k){
                goX = true;
            }
            if(goX){
                chance[info.y] += 1;
                influ[info.x] = 1;

            }
            if(goY){
                chance[info.x] += 1;
                influ[info.y] = 1;

            }
        }
        
        for(int i = 1 ; i <= n; i++){
            System.out.print(influ[i]);
        }
        // for(int i = 1 ; i <= n; i++){
        //     System.out.print(chance[i]);
        // }
        // Please write your code here.
    }

    static class Node implements Comparable<Node>{
        int time;
        int x;
        int y;

        public Node(int time, int x, int y){
            this.time = time;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node other){
            return this.time - other.time;
        }

        @Override
        public String toString(){
            return "[" + time + " " + x + " " +y + "]";
        }
    }
}