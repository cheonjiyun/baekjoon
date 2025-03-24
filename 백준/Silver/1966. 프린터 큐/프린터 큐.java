import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int T = Integer.parseInt(st.nextToken());

    for (int test_case = 1; test_case <= T; test_case++) {

      st = new StringTokenizer(br.readLine().trim());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine().trim());
      Queue<Node> q = new LinkedList<>();
      for (int i = 0; i < n; i++) {
        q.offer(new Node(i, Integer.parseInt(st.nextToken())));
      }

      int count = 0;
      while (!q.isEmpty()) {

        boolean isMax = true;
        Node first = q.poll();

        for (int i = 0; i < q.size(); i++) {
          Node cur = q.poll();
          if (first.important < cur.important) {
            isMax = false;
          }
          q.offer(cur);
        }

        if (isMax) {
          count++;
          if (first.idx == m) {
            break;
          }
        } else {
          q.offer(first);
        }

      }

      sb.append(count).append("\n");

    }

    System.out.println(sb);
  }

  static class Node {
    int idx;
    int important;

    public Node(int idx, int important) {
      super();
      this.idx = idx;
      this.important = important;
    }

    @Override
    public String toString() {
      return "Node [idx=" + idx + ", important=" + important + "]";
    }


  }
}