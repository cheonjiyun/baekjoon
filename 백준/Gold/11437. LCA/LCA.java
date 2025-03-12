import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static List<ArrayList<Integer>> adjList;
  static int[] depthes;
  static boolean[] visited;
  static int[] parents;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int n = Integer.parseInt(st.nextToken());

    adjList = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i <= n; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine().trim());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      adjList.get(a).add(b);
      adjList.get(b).add(a);
    }

    depthes = new int[n + 1];
    visited = new boolean[n + 1];
    parents = new int[n + 1];

    // 미리 depth 기록하기
    checkDepthAndParent(1, 0);

    st = new StringTokenizer(br.readLine().trim());
    int m = Integer.parseInt(st.nextToken());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine().trim());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      sb.append(findLCA(a, b)).append("\n");
    }

    System.out.println(sb);
  }

  static int findLCA(int a, int b) {
    int aDepth = depthes[a];
    int bDepth = depthes[b];

    int aCurrent = a;
    int bCurrent = b;

    // 높이 맞추기
    while (aDepth < bDepth) {
      bCurrent = parents[bCurrent];
      bDepth = depthes[bCurrent];
    }
    while (aDepth > bDepth) {
      aCurrent = parents[aCurrent];
      aDepth = depthes[aCurrent];
    }

    // 부모타고 올라가면서 같은 값 찾기
    while (aCurrent != bCurrent) {
      aCurrent = parents[aCurrent];
      bCurrent = parents[bCurrent];

    }

    return aCurrent;

  }

  static void checkDepthAndParent(int node, int depth) {

    depthes[node] = depth;

    for (int child : adjList.get(node)) {
      if (visited[child])
        continue;
      visited[node] = true;
      parents[child] = node;
      checkDepthAndParent(child, depth + 1);
    }
  }
}