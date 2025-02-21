import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  static int N;
  public static List<List<Integer>> graph;
  public static int[] population;
  public static int[][] maxPopu;
  public static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(in.readLine());
    population = new int[N + 1];
    String[] inputPopu = in.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      population[i + 1] = Integer.parseInt(inputPopu[i]);
    }

    // 인접한 곳 기록
    graph = new ArrayList<List<Integer>>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < N - 1; i++) {
      String[] input = in.readLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    // 각 노드에서 자식으로 출발했을 떄 인구 최대값
    // 0 : 우수X | 1: 우수O
    maxPopu = new int[N + 1][2];
    visited = new boolean[N + 1];

    dfs(1);
    sb.append(Math.max(maxPopu[1][0], maxPopu[1][1]));

    System.out.println(sb);
  }

  private static void dfs(int villageNum) {
    visited[villageNum] = true;

    maxPopu[villageNum][1] += population[villageNum]; // 본인
    for (int neighborNum : graph.get(villageNum)) {
      if (visited[neighborNum])
        continue; // 이미 탐색 완료

      dfs(neighborNum); // 자식 탐색 완료

      maxPopu[villageNum][0] += Math.max(maxPopu[neighborNum][0], maxPopu[neighborNum][1]); // 우수 C
      maxPopu[villageNum][1] += maxPopu[neighborNum][0]; // 이미 우수면 우수X
    }


  }

  // 메모리초과
  // private static int bfs(int villageNum, boolean b) {
  // boolean[] excellent = new boolean[N + 1];
  // excellent[villageNum] = b;
  //
  // Queue<Integer> q = new LinkedList<Integer>();
  // q.offer(villageNum);
  //
  // boolean[] visited = new boolean[N + 1];
  // visited[villageNum] = true;
  //
  // while (q.size() > 0) {
  // int cur = q.remove();
  //
  // boolean isExNe = false;
  // for (int neighborNum : graph.get(cur)) {
  // if (excellent[neighborNum] == true) { // 인접에 우수마을이 있다면
  // isExNe = true;
  // }
  //
  // if (visited[neighborNum] == false) { // 인접 큐 ㄱㄱ
  // visited[neighborNum] = true;
  // q.offer(neighborNum);
  // }
  // }
  //
  // if (cur == 1) // 1이면 넘어가
  // continue;
  // if (isExNe == false) { // 인접에 우수가 하나도 없다면
  // excellent[cur] = true;
  // }
  // }
  //
  // int sum = 0;
  //
  // System.out.println(Arrays.toString(excellent));
  // System.out.println(Arrays.toString(population));
  // for (int i = 1; i <= N; i++) {
  // if (excellent[i] == true) {
  // sum += population[i];
  // }
  // }
  // return sum;
  // }
}