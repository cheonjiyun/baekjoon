import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  private static List<Integer>[] adjList;
  private static int[][] parent;
  private static int n;
  private static int[] depth;
  private static int k;

  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    n = Integer.parseInt(st.nextToken());

    adjList = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) {
      adjList[i] = new ArrayList<Integer>();
    }


    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine().trim());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      adjList[a].add(b);
      adjList[b].add(a);
    }



    // 부모
    int tmp = 1;
    k = 0;
    while (tmp <= n) {
      tmp <<= 1;
      k++;
    }

    depth = new int[n + 1];
    parent = new int[n + 1][k];

    setParent(1, 1);
    fillParents();
    // for (int i = 0; i < n + 1; i++) {
    // System.out.println(Arrays.toString(parent[i]));
    // }
    // System.out.println(Arrays.toString(depth));

    st = new StringTokenizer(br.readLine().trim());
    int m = Integer.parseInt(st.nextToken());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine().trim());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      sb.append(LCA(a, b)).append("\n");
    }

    System.out.println(sb);
  }

  private static int LCA(int a, int b) {
    if (depth[a] < depth[b]) {
      int temp = a;
      a = b;
      b = temp;
    }

    for (int i = k - 1; i >= 0; i--) {
      if (Math.pow(2, i) <= depth[a] - depth[b]) {
        a = parent[a][i];
      }
    }

    if (a == b) {
      return a;
    }

    // System.out.println(h);
    for (int i = k - 1; i >= 0; i--) {
      if (parent[a][i] != parent[b][i]) {
        a = parent[a][i];
        b = parent[b][i];
      }
      // System.out.println(a + " " + b);
    }

    return parent[a][0];
  }

  private static void setParent(int node, int cnt) {
    depth[node] = cnt;

    for (int next : adjList[node]) {
      if (depth[next] == 0) {
        setParent(next, cnt + 1);
        parent[next][0] = node;
      }
    }

  }



  private static void fillParents() {
    for (int i = 1; i < k; i++) {
      for (int j = 1; j <= n; j++) {
        parent[j][i] = parent[parent[j][i - 1]][i - 1];
      }
    }
  }
}