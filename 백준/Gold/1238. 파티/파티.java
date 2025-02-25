import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String[] input1 = in.readLine().split(" ");
    int n = Integer.parseInt(input1[0]);
    int m = Integer.parseInt(input1[1]);
    int x = Integer.parseInt(input1[2]);

    ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
    ArrayList<ArrayList<Node>> reverseList = new ArrayList<ArrayList<Node>>();

    for (int i = 0; i <= n; i++) {
      list.add(new ArrayList<>());
      reverseList.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      String[] input = in.readLine().split(" ");
      int start = Integer.parseInt(input[0]);
      int end = Integer.parseInt(input[1]);
      int time = Integer.parseInt(input[2]);

      list.get(start).add(new Node(end, time));
      reverseList.get(end).add(new Node(start, time));
    }

    // -----------------------------------------------
    int[] minTimeFromX = dijkstra(list, x, n);
    int[] minTimeToX = dijkstra(reverseList, x, n);

    int result = 0;
    for (int i = 1; i <= n; i++) {
      result = Math.max(result, minTimeFromX[i] + minTimeToX[i]);
    }

    sb.append(result);


    System.out.println(sb);
  }

  private static int[] dijkstra(ArrayList<ArrayList<Node>> list, int x, int n) {
    Queue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(x, 0));

    boolean[] isVisited = new boolean[n + 1];
    int[] minTime = new int[n + 1];
    Arrays.fill(minTime, Integer.MAX_VALUE);
    minTime[x] = 0;

    while (!pq.isEmpty()) {
      Node currentNode = pq.poll();
      int curEnd = currentNode.end;

      if (!isVisited[curEnd]) {
        isVisited[curEnd] = true;

        for (Node node : list.get(curEnd)) {
          if (!isVisited[node.end] && minTime[node.end] > minTime[curEnd] + node.time) {
            minTime[node.end] = minTime[curEnd] + node.time;
            pq.offer(new Node(node.end, minTime[node.end]));
          }
        }
      }
    }

    return minTime;
  }

  static class Node implements Comparable<Node> {
    int end;
    int time;

    public Node(int end, int time) {
      super();
      this.end = end;
      this.time = time;
    }

    @Override
    public String toString() {
      return "Node [end=" + end + ", time=" + time + "]";
    }

    @Override
    public int compareTo(Node o) {
      // TODO Auto-generated method stub
      return this.time - o.time;
    }


  }
}