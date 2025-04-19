import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
  private static int JUMP;

  public static void main(String args[]) throws Exception {


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    for (int test_case = 1; test_case <= T; test_case++) {
      JUMP = 0;
      sb.append("#").append(test_case).append(" ");

      List<Integer> searchList = new ArrayList<>();
      int N = Integer.parseInt(br.readLine());

      // 최대 높이
      int tmp = 1;
      while (tmp < N) {
        tmp = tmp << 1;
        JUMP++;
      }

      int[][] parents = new int[N + 1][JUMP + 1];
      int[] depths = new int[N + 1];
      long result = 0;
      ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
      for (int i = 0; i <= N; i++) {
        adjList.add(new ArrayList<>());
      }

      // 입력
      st = new StringTokenizer(br.readLine());
      for (int i = 2; i <= N; i++) {
        int nodeNum = Integer.parseInt(st.nextToken());
        adjList.get(nodeNum).add(i); // 자식 기록
      }

      setDepths(1, N, adjList, parents, depths, searchList); // bfs를 먼저하고
      fillParent(N, parents); // 부모를 기록하고

      for (int i = 0; i < searchList.size() - 1; i++) { // 방문 순서대로
        int current = searchList.get(i);
        int next = searchList.get(i + 1);
        int sameParent = LCA(current, next, depths, parents);


        result += depths[current] - depths[sameParent]; // 가장 짧은 거리
        result += depths[next] - depths[sameParent]; // 가장 짧은 거리
      }

      sb.append(result).append('\n');
    }
    bw.write(sb.toString());
    bw.close();
  }


  private static int LCA(int current, int next, int[] depths, int[][] parents) {
    if (depths[current] < depths[next]) { // a를 깊게
      int temp = current;
      current = next;
      next = temp;
    }
    for (int i = JUMP; i >= 0; i--) {
      int diff = depths[current] - depths[next]; // 차이만큼 하나 올림
      if (diff >= Math.pow(2, i)) { // 2 ^ i 만큼 올려도 되는가
        current = parents[current][i];
      }
    }

    if (current == next) {
      return current;
    }

    for (int i = JUMP; i >= 0; i--) {
      if (parents[current][i] != parents[next][i]) {
        current = parents[current][i];
        next = parents[next][i];
      }
    }
    return parents[current][0];
  }


  private static void setDepths(int idx, int N, ArrayList<ArrayList<Integer>> adjList,
      int[][] parents, int[] depths, List<Integer> searchList) {

    Queue<Integer> q = new LinkedList<>();
    q.offer(idx);

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int cur = q.poll();
        searchList.add(cur); // 방문순서기록

        for (int child : adjList.get(cur)) {
          parents[child][0] = cur; // 직전 부모에 현재(자식)을 기록한다. LCA nlogn을 위해 미리 부모를 기록하는 부분 1
          depths[child] = depths[cur] + 1; // 부모보다 깊이가 하나 더 큼
          q.offer(child);
        }

      }
    }
  }

  private static void fillParent(int N, int[][] parents) {
    // LCA nlogn을 위해 미리 부모를 기록하는 부분 1
    for (int i = 1; i <= JUMP; i++) {
      for (int j = 1; j <= N; j++) {
        int halfParent = parents[j][i - 1]; // 2 * (i-1) 번째 부모
        parents[j][i] = parents[halfParent][i - 1]; // 부모의 부모 ????
      }
    }
  }
}