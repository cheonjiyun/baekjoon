import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

  static List<Integer>[] edges;
  static int a;
  static int b;
  // 결과를 전역으로 저장
  static int resultMinSize;
  static int resultNode;

  public static void main(String args[]) throws Exception {

    Scanner sc = new Scanner(System.in);
    int T;
    T = Integer.valueOf(sc.nextLine());

    for (int test_case = 1; test_case <= T; test_case++) {

      // 초기화
      resultMinSize = 0;
      resultNode = 0;

      // 입력
      String[] input = sc.nextLine().split(" ");
      int v = Integer.valueOf(input[0]);
      int e = Integer.valueOf(input[1]);
      a = Integer.valueOf(input[2]);
      b = Integer.valueOf(input[3]);

      edges = new ArrayList[v + 1];
      for (int i = 0; i < v + 1; i++) {
        edges[i] = new ArrayList<>();
      }

      String[] inputEdge = sc.nextLine().split(" ");
      for (int i = 0; i < inputEdge.length; i += 2) {
        int parent = Integer.valueOf(inputEdge[i]);
        int child = Integer.valueOf(inputEdge[i + 1]);

        edges[parent].add(child);
      }

      ReturnType result = findChildAndSize(1);

      System.out.printf("#%d %d %d\n", test_case, resultNode, resultMinSize);
    }
  }

  // 노드 돌면서 -> 본인과 자식 합쳐서 사이즈, 본인과 자식 합쳐서 a가 있는지, b가 있는지
  static class ReturnType {
    int size;
    boolean hasA;
    boolean hasB;

    public ReturnType(int size, boolean hasA, boolean hasB) {
      super();
      this.size = size;
      this.hasA = hasA;
      this.hasB = hasB;
    }

    @Override
    public String toString() {
      return "ReturnType [size=" + size + ", hasA=" + hasA + ", hasB=" + hasB + "]";
    }
  }

  public static ReturnType findChildAndSize(int start) {

    ReturnType result = new ReturnType(1, false, false);

    // 자식들
    for (int child : edges[start]) {
      ReturnType childResult = findChildAndSize(child);
      result.size += childResult.size;
      if (childResult.hasA) {
        result.hasA = true;
      }
      if (childResult.hasB) {
        result.hasB = true;
      }
    }

    // 나
    if (start == a) {
      result.hasA = true;
    }
    if (start == b) {
      result.hasB = true;
    }

    // 결과
    if (result.hasA && result.hasB && resultMinSize == 0) {
      resultMinSize = result.size;
      resultNode = start;
    }

    return result;
  }
}
