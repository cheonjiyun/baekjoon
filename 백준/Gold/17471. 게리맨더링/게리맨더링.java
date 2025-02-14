import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {


  static int[] areas;
  static int n;
  static int[] population;
  static List<Integer>[] connect;

  static boolean[] visited;

  static int result = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {

    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    population = new int[n + 1];
    connect = new ArrayList[n + 1];

    for (int i = 1; i <= n; i++) {
      population[i] = sc.nextInt();
    }

    for (int i = 1; i <= n; i++) {
      connect[i] = new ArrayList<>();
      int nextn = sc.nextInt();
      for (int j = 1; j <= nextn; j++) {
        connect[i].add(sc.nextInt());
      }
    }

    areas = new int[n + 1];
    dfs(1);

    if (result == Integer.MAX_VALUE)
      System.out.println(-1);
    else
      System.out.println(result);
  }

  static void dfs(int areaIdx) {

    if (areaIdx == n + 1) {
      // 선거구 2개인지
      int electionSum = 0;

      // 같은 선거구 다 방문처리
      visited = new boolean[n + 1];
      for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
          bfs(i, areas[i]);
          electionSum++;
        }
      }

      // 구역이 딱 2개 나오면
      if (electionSum == 2) {
        // 구역별로 인구를 센다.
        int areaPopulation1 = 0;
        int areaPopulation2 = 0;
        for (int i = 1; i <= n; i++) {
          if (areas[i] == 1)
            areaPopulation1 += population[i];
          else
            areaPopulation2 += population[i];
        }

        result = Math.min(result, Math.abs(areaPopulation1 - areaPopulation2));
      }
      return;
    }


    areas[areaIdx] = 1;
    dfs(areaIdx + 1);

    areas[areaIdx] = 2;
    dfs(areaIdx + 1);
  }


  static void bfs(int areaIdx, int areaNum) {
    // 같은 선거구 다 방문처리

    // 지역
    visited[areaIdx] = true;

    Queue<Integer> q = new ArrayDeque<>();
    q.add(areaIdx);

    while (!q.isEmpty()) {
      int current = q.poll();
      for (int next : connect[current]) {
        if (!visited[next] && areas[next] == areaNum) {
          visited[next] = true;
          q.add(next);
        }
      }
    }
  }
}
